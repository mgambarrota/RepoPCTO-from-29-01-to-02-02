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

  constructor(dipendente?: DipendenteBE) {
    this.id = dipendente?.id;
    this.nome = dipendente?.nome;
    this.cognome = dipendente?.cognome;
    this.data_nascita = dipendente?.data_nascita;
    this.sede_appartenenza = dipendente?.sede_appartenenza;
    this.data_fine_rapporto = dipendente?.data_fine_rapporto;
    this.data_assunzione = dipendente?.data_assunzione;
  }

  toBE():DipendenteBE{
    // Trasformare oggetto Frontend in un oggetto Backend
    return{
      id: this.id,
      nome: this.nome,
      cognome: this.cognome,
      data_nascita: this.data_nascita,
      data_assunzione: this.data_assunzione,
      sede_appartenenza: this.sede_appartenenza,
      data_fine_rapporto: this.data_fine_rapporto,
    }
  }

  formToModel(form: Object): DipendenteFE{
    Object.keys(form)?.forEach(
        (prop) => {
            if(form[prop]) this[prop] = form[prop];
        }
    )
    return this;
  }
  
}
