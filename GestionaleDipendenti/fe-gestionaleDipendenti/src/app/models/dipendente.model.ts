export interface DipendenteBE {
  id?: number;
  nome?: string;
  cognome?: string;
  data_nascita?: Date;
  data_assunzione?: Date;
  sede_appartenenza?: string;
  data_fine_rapporto?: Date;
}

export class DipendenteFE {
  id?: number;
  nome?: string;
  cognome?: string;
  data_nascita?: Date;
  data_assunzione?: Date;
  sede_appartenenza?: string;
  data_fine_rapporto?: Date;

    constructor(dipendente: DipendenteBE) {
        this.id = dipendente?.id;
        this.nome = dipendente?.nome;
        this.cognome = dipendente?.cognome;
        this.data_nascita = dipendente?.data_nascita;
        this.sede_appartenenza = dipendente?.sede_appartenenza;
        this.data_fine_rapporto = dipendente?.data_fine_rapporto;
        this.data_assunzione = dipendente?.data_assunzione;
    }
}
