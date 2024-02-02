import { ApiError } from "./api-error.model";

export interface ApiResponse<T> {
    codiceEsitoOperazione: number;
    descrizioneEsitoOperazione: string;
    oggettiRestituiti:number;
    payload: T;
    oggettiTotali: number;
    errori: ApiError;
}