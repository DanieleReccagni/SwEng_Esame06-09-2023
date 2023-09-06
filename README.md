# CORSO INGEGNERIA DEL SOFTWARE A.A. 2022/23

# Esame del 6 settembre 2023

* `<Cognome> <Nome> <matricola>`

Dopo avere effettuato il **fork** su `gitlab.di.unimi.it` e il **clone** in
locale, modificate questo README
inserendo i vostri dati seguendo lo schema sopra riportato.
Concedete quindi i permessi di lettura (livello **reporter**) al vostro progetto su gitlab ai
docenti (`carlo.bellettini` e `mattia.monga`).

## Processo

Il progetto va implementato secondo la *metodologia TDD*, utilizzando `git flow`, quindi occorre iniziare con un `git flow init`.
Poi ripetere i passi seguenti fino ad aver implementato tutte le funzionalità richieste:

* creare un nuovo *branch* per la funzionalità corrente attraverso l'esecuzione del comando `git flow feature start`,
* implementare un test per le funzionalità volute;
* verificare che **il codice compili correttamente**, ma l'**esecuzione del test fallisca**;
  solo a questo punto effettuare un *commit* iniziando il messaggio di commit con la stringa `ROSSO:`,
* aggiungere la minima implementazione necessaria a realizzare la funzionalità, in modo che **il
  test esegua con successo**; solo a questo punto
  effettua un *commit* iniziando il messaggio di commit con la stringa `VERDE:`,
* procedere, se necessario, al **refactoring** del codice, accertandosi che le modifiche non
  comportino il fallimento di alcun test; solo in questo caso fa seguire a ogni
  passo un *commit* iniziando il messaggio di commit con la stringa `REFACTORING:`,
* eseguire il *merge* del *branch* per la funzionalità sviluppata all'interno del *branch develop*
  attraverso il comando `git flow feature finish`,
* **solo in fase di rilascio**, esegue una *release* all'interno del *branch master* attraverso il comando `git flow release start` e successivamente `git flow release finish`,
* effettua un *push* (di tutti i *branch*) con `git push origin --all` e poi `git push origin --tags`.

# SUPPLENZE SCOLASTICHE

Obiettivo dell'esercizio è progettare e realizzare un insieme di classi atte a
produrre un programma Java che si occupi di gestire l'assegnazione delle
supplenze nelle scuole amministrate da un determinato ufficio scolastico
regionale (USR).

L'USR riceve le richieste di supplenza, costituite dalle informazioni
riguardanti l'istituto (un codice alfanumerico composto da due lettere maiuscole
seguite da un numero di 3 cifre), la durata in mesi della supplenza, il comune sede
dell'istituto e la data d'inizio della supplenza.

L'USR ha a disposizione una vista (ci sono due istanze di questa vista) con cui può:

- inserire nel sistema una richiesta di supplenza col formato
>    *codiceIstituto* **:**  *durataInMesi* **:** *comune* **:** *datainizio* 

***ATTENZIONE***: Non ci può essere più di una richiesta di supplenza con lo stesso codice di istituto e data d'inizio


Gli insegnanti hanno a disposizione due viste con cui possono consultare l'elenco delle supplenze (max. 8) ancora da assegnare

- la prima è ordinata per comune, mentre la seconda per durata 
- in entrambi i casi la seconda  chiave di ordinamento è la data di inizio.


Mediante un ulteriore tipo di vista (anche questa in due istanze), gli insegnanti possono accettare una determinata supplenza, inviando il proprio *codice insegnante*
con il formato 
>    *codinsegnante* **:** *codiceIstituto* **:** *dataInizio*

Tra i controlli da effettuare ci sono :

- che il testo inserito rispetti il formato richiesto (numero corretto di campi, campi validi, ecc.)
- Una data deve essere fornita nel formato gg/mm/aaaa
- Un codice insegnante è composto da una lettera maiuscola, un numero di due cifre, e da una ulteriore lettera maiuscola.

Vi vengono fornite già due classi *Viste* del sistema:

- `USRView`: una vista che permette di inserire una stringa , sottometterla mediante pressione di un bottone e visualizzare eventuali errori;
- `DisplayView`: un display generale che permette di visualizzare alcune righe di testo e può essere usato per visualizzare le richieste delle supplenze.

e alcune interfacce: InputView, OutputView, Presenter.

Viene fornita anche una prima versione della classe `Main`, e una classe (`GUITest`) contenente  alcuni possibili test d'integrazione/validazione.

Della classe `Modello` viene data la prima parte di una funzione `readFile` che il Main richiama per leggere un CSV file con alcune richieste da inserire inizialmente nel sistema.

Completare, in modo da realizzare un'organizzazione del sistema di tipo
*Model-View-Presenter*, le classi già presenti e aggiungere le
classi e le interfacce utili a raggiungere le richieste indicate.

Il formato con cui devono essere presentate le segnalazioni nelle due viste `DisplayView` e alcuni dei messaggi di errore sono ricavabili dalle figure seguenti e/o
dai test di integrazione.


**TUTTE LE CLASSI DATE POSSONO ESSERE MODIFICATE (CANCELLATE, COMPLETATE) PER
ADERIRE A DIFFERENTI IDEE DI PROGETTAZIONE**

Lanciando il codice attuale (tramite il task **run** di gradle) si ottiene inizialmente una
interfaccia come quella nella figura sottostante.


![start](img_0.png)


Dopo avere implementato il programma la schermata iniziale dovrebbe essere diventata come quella nella figura sottostante.

![start](img_1.png)



### Suggerimenti

Oltre all'uso del pattern _Model-View-Presenter_, vi consigliamo di considerare
lo sfruttamento
al fine di scrivere un codice migliore anche di altri pattern (ad es. il pattern
_Strategy_, o il pattern _Template_) e in
ogni caso di prestare grande attenzione al rispetto dei principi **SOLID** di
buona progettazione Object Oriented.

Prestare estrema attenzione anche a garantire una corretta encapsulation dello
stato da parte delle arie classi (ad
esempio del Model) in modo da garantire l'assenza di **escaping references**  anche di
solo parte dello stato.

### Testing

Mano a mano che si sviluppa il progetto, si deve controllare di mantenere una
copertura, sia dei comandi che delle
decisioni, soddisfacente (se inferiore al 100% inserire un commento che spieghi
perché non è possibile raggiungerlo).

Sono presenti anche alcuni test di integrazione.
Vi dovrebbero essere di aiuto anche per capire cosa serve fare (cioè come
specifiche).

Può essere utile oltre ai test di unità che scrivete durante il TDD prevedere di aggiungere anche qualche test di 
integrazione per verificare che il sistema funzioni correttamente anche facendo interagire le diverse classi reali.

### Consegna

Al termine del laboratorio dovete impacchettare l'ultima versione stabile (non ci possono essere test di unità che 
falliscono) a cui siete arrivati come una _release_ di gitflow chiamata
"consegna" ed effettuare un ultimo *push* anche di tutti i rami locali (comprese quindi eventuali feature aperte ma non 
completate e non presenti nella realease "consegna"):
`git push origin --all` e poi `git push origin --tags`

## **Verificate su `gitlab.di.unimi.it`** che ci sia la completa traccia dei *commit* effettuati e di averne dato visibilità ai docenti.
