import { Evento } from './evento';
import { RedeSocial } from './rede-social';

export interface Artista {

  artista_id: number;
	nome: string;
	imagemURL:string;
	telefone:string;
	email:string;
	redes_sociais:RedeSocial[];
	evento:Evento;

}
