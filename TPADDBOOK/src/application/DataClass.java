package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {

    private List<Person> importList;  // liste des personnes importées
    private List<Person> exportList;  // liste des personnes exportées

    public DataClass() {
        importList = new ArrayList<>();  // initialiser la liste des importations avec des valeurs par défaut
        importList.add(new Person("sami", "djebbi", "djebbi@gmail.com",27));
        importList.add(new Person("touhami", "djebbi", "djebbi@gmail.com",28));
        importList.add(new Person("toukabri", "djebbi", "djebbi@gmail.com",20));
        exportList = new ArrayList<>();  // initialiser la liste des exportations à une liste vide
    }

    /**
     * Obtient la liste des personnes importées.
     *
     * @return La liste des personnes importées.
     */
    public List<Person> getImportList() {
        return importList;
    }

    /**
     * Remplace la liste des personnes importées par une nouvelle liste.
     *
     * @param importList La nouvelle liste des personnes importées.
     */
    public void setImportList(List<Person> importList) {
        this.importList.clear();  // supprimer toutes les entrées actuelles dans la liste des importations
        this.importList.addAll(importList);  // ajouter toutes les nouvelles entrées dans la liste des importations
    }

    /**
     * Obtient la liste des personnes exportées.
     *
     * @return La liste des personnes exportées.
     */
    public List<Person> getExportList() {
        return exportList;
    }

    /**
     * Remplace la liste des personnes exportées par une nouvelle liste, et affiche chaque personne exportée.
     *
     * @param exportList La nouvelle liste des personnes exportées.
     */
    public void setExportList(List<Person> exportList) {
        this.exportList.clear();  // supprimer toutes les entrées actuelles dans la liste des exportations
        this.exportList.addAll(exportList);  // ajouter toutes les nouvelles entrées dans la liste des exportations
        for (Person person : this.exportList) {  // afficher chaque personne exportée
            System.out.println(person);
        }
    }
}
