import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-eventos',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css']
})
export class EventosComponent implements OnInit {

  eventos: any = [];
  eventosFiltrados: any = [];
  _filtroLista: string = '';

  get filtroLista(): string {
    return this._filtroLista;
  }

  set filtroLista(value: string) {
    this._filtroLista = value;
    this.eventosFiltrados = this.filtroLista ? this.filtrarEventos(this.filtroLista) : this.eventos;
  }

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getEventos();
    console.log(this.filtroLista.length)
    this.eventosFiltrados = this.eventos;
  }

  filtrarEventos(filtrarPor: string): any {
    filtrarPor = filtrarPor.toLocaleLowerCase();
    return this.eventos.filter(
      evento => evento.tema.toLocaleLowerCase().indexOf(filtrarPor) !== -1
    );
  }

  getEventos() {
    this.http.get<any[]>(`${environment.url}/evento`).subscribe(res => {

      res.forEach(element => {
        element.data_evento = new Date(element.data_evento).toLocaleDateString()
      });
      this.eventos = res;
      this.eventosFiltrados = this.filtroLista.length == 0 ? this.eventos : [];
      console.log(res)
    }, err => {
      console.error(err);
    })
  }

}
