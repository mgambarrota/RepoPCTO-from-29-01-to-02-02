export interface DipendenteBE {
  id?: number;
  nome?: string;
  cognome?: string;
  data_nascita?: Date;
  sede_appartenenza?: string;
  data_assunzione?: Date;
  data_fine_rapporto?: Date;
}

export class DipendenteFE{
  id?: number;
  nome?: string;
  cognome?: string;
  data_nascita?: Date;
  sede_appartenenza?: string;
  data_assunzione?: Date;
  data_fine_rapporto?: Date;
  constructor(dipendente?: DipendenteBE){
    this.id = dipendente?.id;
    this.nome = dipendente?.nome;
    this.cognome = dipendente?.cognome;
    this.data_nascita = dipendente?.data_nascita;
    this.data_fine_rapporto = dipendente?.data_fine_rapporto;
    this.data_assunzione  = dipendente?.data_assunzione;
    this.sede_appartenenza = dipendente?.sede_appartenenza;
  }

  toBE():DipendenteBE{
    return{
      id: this.id,
      nome: this.nome,
      cognome: this.cognome,
      data_nascita: this.data_nascita,
      sede_appartenenza: this.sede_appartenenza,
      data_assunzione: this.data_assunzione,
      data_fine_rapporto: this.data_fine_rapporto
    }
  }


  formToModel(form: Object): DipendenteFE{
    Object.keys(form)?.forEach(
      (key) => {
        if(form[key]){
          this[key] = form[key];
        }
      }
    )

    return this;
  }
}
