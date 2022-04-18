package oop.multithreading.managerworkers;

import javax.swing.*;

/**
 * Si implementi un’applicazione multi-threaded per la ricerca di numeri primi.
 * Il software deve sfruttare la moderne architetture multicore suddividendo
 * l’intervallo di numeri interi in cui effettuare la ricerca in blocchi
 * contigui. Ad esempio la ricerca dei primi compresi nell’intervallo 1-10000
 * potrebbe essere divisa in 10 blocchi contigui di 1000 elementi ciascuno. Ogni
 * blocco deve essere processato da un thread separato il quale, una volta
 * terminata la computazione, ritorna i risultati al thread principale.
 *
 * @author Nicola Bicocchi
 */
public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ManagerWorkersUI::new);
    }
}
