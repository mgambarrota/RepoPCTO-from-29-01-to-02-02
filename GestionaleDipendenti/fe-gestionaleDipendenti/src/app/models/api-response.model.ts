import { APIError } from "./api-error.model";

export interface APIResponse<T>{
    codiceEsitoOperazione: number;
    descrizioneEsitoOperazione: string;
    oggettiRestituiti: number;
    oggettiTotaliRestituiti: number;
    payload: T;
    errori: APIError;

}