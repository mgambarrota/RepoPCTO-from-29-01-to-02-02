import { ApiError } from "./api-error.model";

export interface ApiResponse<T> {
  codiceEsitoOperazione: number;
  descrizioneEsitoOperazione: string;
  oggettiRestituiti: number;
  oggettiTotali: number;
  payload: T;
  errori: ApiError;
}
