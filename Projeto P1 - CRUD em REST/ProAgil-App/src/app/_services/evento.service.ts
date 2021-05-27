import { Evento } from './../_models/evento';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  constructor(private http: HttpClient) { }

  getAllEventos():Observable<Evento[]>{
    return this.http.get<Evento[]>(`${environment.url}/evento`);
  }
  getEventosByTema(tema:string):Observable<Evento[]>{
    return this.http.get<Evento[]>(`${environment.url}/evento/getEventoByTema/${tema}`);
  }
  getEventosById(id:number):Observable<Evento[]>{
    return this.http.get<Evento[]>(`${environment.url}/evento/${id}`);
  }

  // postUpload(file: File, name: string) {
  //   const fileToUplaod = <File>file[0];
  //   const formData = new FormData();
  //   formData.append('file', fileToUplaod, name);

  //   return this.http.post(`${environment.url}/evento`, formData);
  // }

  postEvento(evento: Evento) {
    return this.http.post(`${environment.url}/evento`, evento);
  }

  putEvento(evento: Evento) {
    evento.data_evento = "2020-04-19"
    console.log(evento)
    return this.http.put(`${environment.url}/evento`, evento);
  }

  deleteEvento(id: number) {
    return this.http.delete(`${environment.url}/evento/${id}`);
  }

}
