# Triage

Vogliamo realizzare il seguente progetto:

![triage](assets/triage.jpg)

## Istruzioni

### Person e patient

`Severity`: indica la gravità del caso.

### La coda (Queue)

Una coda è una struttura dati di tipo FIFO (ovvero First In First Out). Può essere implementata in molti modi ma noi, per comodità, useremo un ArrayList. I metodi che una coda deve avere per forza sono:

* `enqueue`: aggiunge un elemento in coda
* `dequeue`: rimuove il primo elemento della coda (se c'è)

Noi, per comodità, vogliamo aggiungere anche i seguenti metodi:

* `size`
* `isEmpty`
* `get(int i)`: restituisce l'i-esimo elemento (se c'è)

### La coda con priorità (il nostro Triage)

Possiamo vedere anche questa come una coda, con gli stessi metodi di `Queue`, ma al suo interno dà priorità a secondo del codice di gravità con questo ordine: RED, YELLOW, GREEN.