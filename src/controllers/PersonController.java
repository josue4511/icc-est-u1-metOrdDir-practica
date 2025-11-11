package controllers;

import models.Person;
import java.text.Normalizer;

public class PersonController {

    
    public void sortByName(Person[] people) {
        if (people == null || people.length <= 1) {
            return; 
        }

        
        for (int i = 1; i < people.length; i++) {
            Person current = people[i];
            if (current == null) continue;

            int j = i - 1;
            while (j >= 0 && shouldSwap(people[j], current)) {
                people[j + 1] = people[j];
                j--;
            }
            people[j + 1] = current;
        }
    }

    
    private boolean shouldSwap(Person a, Person b) {
        if (a == null) return false;
        if (b == null) return true;

        String nameA = normalize(a.getName());
        String nameB = normalize(b.getName());
        return nameA.compareTo(nameB) > 0;
    }

    
    private String normalize(String name) {
        if (name == null) return "";
        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("\\p{M}", ""); 
        return normalized.toLowerCase();
    }
}
