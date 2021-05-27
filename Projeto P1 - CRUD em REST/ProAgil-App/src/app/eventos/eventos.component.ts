import * as moment from 'moment';
import { DateTimeFormatPipe } from './../helpers/date-pipe-custom/datetime-format-pipe';
import { ToastrService } from 'ngx-toastr';
import { Evento } from './../_models/evento';
import { EventoService } from './../_services/evento.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import ptBr from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
registerLocaleData(ptBr)

@Component({
  selector: 'app-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent implements OnInit {

  titulo = 'Eventos';
  dataEvento: string;
  eventosFiltrados: Evento[];
  eventos: Evento[];
  evento: Evento;
  modoSalvar = 'post';

  imagemLargura = 50;
  imagemMargem = 2;
  mostrarImagem = false;
  registerForm: FormGroup;
  bodyDeletarEvento = '';

  file: File;
  fileNameToUpdate: string;

  dataAtual: string;

  _filtroLista = '';

  constructor(
    private eventoService: EventoService
    , private modalService: BsModalService
    , private fb: FormBuilder
    , private toastr: ToastrService
    , public dateFormat: DateTimeFormatPipe,
  ) {
  }

  get filtroLista(): string {
    return this._filtroLista;
  }
  set filtroLista(value: string) {
    this._filtroLista = value;
    this.eventosFiltrados = this.filtroLista ? this.filtrarEventos(this.filtroLista) : this.eventos;
  }

  editarEvento(evento: Evento, template: any) {
    this.modoSalvar = 'put';
    this.openModal(template);
    this.evento = Object.assign({}, evento);
    this.fileNameToUpdate = evento.imagem_URL.toString();
    this.evento.imagem_URL= '';
    this.registerForm.patchValue(this.evento);
  }

  novoEvento(template: any) {
    this.modoSalvar = 'post';
    this.openModal(template);
  }

  excluirEvento(evento: Evento, template: any) {
    this.openModal(template);
    this.evento = evento;
    this.bodyDeletarEvento = `Tem certeza que deseja excluir o Evento: ${evento.tema}, Código: ${evento.evento_id}`;
  }

  confirmeDelete(template: any) {
    this.eventoService.deleteEvento(this.evento.evento_id).subscribe(
      () => {
        template.hide();
        this.getEventos();
        this.toastr.success('Deletado com Sucesso');
      }, error => {
        this.toastr.error('Erro ao tentar Deletar');
        console.log(error);
      }
    );
  }

  openModal(template: any) {
    this.registerForm.reset();
    template.show();
  }

  ngOnInit() {
    moment.locale('pt-br');
    this.validation();
    this.getEventos();

  }

  filtrarEventos(filtrarPor: string): Evento[] {
    filtrarPor = filtrarPor.toLocaleLowerCase();
    return this.eventos.filter(
      evento => evento.tema.toLocaleLowerCase().indexOf(filtrarPor) !== -1
    );
  }

  alternarImagem() {
    this.mostrarImagem = !this.mostrarImagem;
  }

  validation() {
    this.registerForm = this.fb.group({
      tema: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
      local: ['', Validators.required],
      data_evento: ['', Validators.required],
      imagem_URL: ['', Validators.required],
      quantidade_pessoas: ['', [Validators.required, Validators.max(120000)]],
      telefone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onFileChange(event) {
    const reader = new FileReader();

    if (event.target.files && event.target.files.length) {
      this.file = event.target.files;
      console.log(this.file);
    }
  }

  uploadImagem() {
    if (this.modoSalvar === 'post') {
      const nomeArquivo = this.evento.imagem_URL.split('\\', 3);
      this.evento.imagem_URL = nomeArquivo[2];

      // this.eventoService.postUpload(this.file, nomeArquivo[2])
      //   .subscribe(
      //     () => {
      //       this.dataAtual = new Date().getMilliseconds().toString();
      //       this.getEventos();
      //     }
      //   );
    } else {
      this.evento.imagem_URL = this.fileNameToUpdate;
      // this.eventoService.postUpload(this.file, this.fileNameToUpdate)
      //   .subscribe(
      //     () => {
      //       this.dataAtual = new Date().getMilliseconds().toString();
      //       this.getEventos();
      //     }
      //   );
    }
  }

  salvarAlteracao(template: any) {
    if (this.registerForm.valid) {
      if (this.modoSalvar === 'post') {

        this.evento = Object.assign({}, this.registerForm.value);
        this.uploadImagem();

        this.eventoService.postEvento(this.evento).subscribe(
          (novoEvento: Evento) => {
            template.hide();
            this.getEventos();
            this.toastr.success('Inserido com Sucesso!');
          }, error => {
            this.toastr.error(`Erro ao Inserir: ${error}`);
          }
        );
      } else {


        var teste = Object.assign({
          evento_id:this.evento.evento_id,
          artistas:this.evento.artistas,
          redes_sociais:this.evento.redes_sociais,
          lotes:this.evento.lotes}, this.registerForm.value);

        this.uploadImagem();
        console.log(teste)
        this.eventoService.putEvento(teste).subscribe(
          () => {
            template.hide();
            this.getEventos();
            this.toastr.success('Editado com Sucesso!');
          }, error => {
            this.toastr.error(`Erro ao Editar: ${error}`);
          }
        );
      }
    }
  }

  getEventos() {
    this.dataAtual = new Date().getMilliseconds().toString();

    this.eventoService.getAllEventos().subscribe(
      (_eventos: Evento[]) => {
        _eventos.forEach(element => {
          element.data_evento = this.transformDate(element.data_evento)
        });

        this.eventos = _eventos;

        this.eventosFiltrados = this.eventos;
        console.log(this.eventos);
      }, error => {
        this.toastr.error(`Erro ao tentar Carregar eventos: ${error}`);
      });
  }



  transformDate(date){
    return this.dateFormat.transform(date).toString();
   }

}
