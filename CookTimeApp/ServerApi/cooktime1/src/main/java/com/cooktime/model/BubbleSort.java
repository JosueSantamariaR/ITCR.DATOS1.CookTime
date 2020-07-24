package com.cooktime.model;

import java.util.ArrayList;

public class BubbleSort {

    public void sort(ArrayList<Recipe> array) {

        Recipe aux;
        boolean changes;

        while (true) {

            changes = false;

            for (int i = 1; i < array.size(); i++) {

                if (array.get(i).getYear() <= array.get(i - 1).getYear()) {

                    if (array.get(i).getMonth() <= array.get(i - 1).getMonth()) {

                        if (array.get(i).getDay() <= array.get(i - 1).getDay()) {

                            aux = array.get(i);
                            array.set(i, array.get(i - 1));
                            array.set(i - 1, aux);
                            changes = true;

                        }

                    }

                }

            }

            if (changes == false) {

                break;

            }

        }

    }

}
