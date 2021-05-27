import { Artista } from './artista';
import { RedeSocial } from './rede-social';
import { Lote } from './lote';
export interface Evento {

   evento_id: number;
	 local:string;
	 data_evento:string;
	 tema:string;
	 quantidade_pessoas: number;
	 lotes:Lote[];
	 imagem_URL:string;
	 telefone: string;
	 email:string;
	 redes_sociais:RedeSocial[];
	 artistas:Artista[];
}
