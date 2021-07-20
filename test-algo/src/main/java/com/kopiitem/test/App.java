package com.kopiitem.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * @author lie.donny
 */
public class App {
    public static void main(String[] args) {

        List<Building> buildingList = Arrays.asList(
                new Building(false, true, false),
                new Building(true, false, false),
                new Building(true, true, false),
                new Building(false, true, false),
                new Building(false, true, true)
        );

        int maxDistance = 0;
        int minDistance = 5;
        int resultIndex = 0;

        for (int i = 0; i < 5; i++) {
            int totalDistance = 0;
            maxDistance = 0;
            totalDistance = getTotalDistanceGym(buildingList, i);
            if (maxDistance < totalDistance) {
                maxDistance = totalDistance;
            }


            totalDistance = getTotalDistanceSchool(buildingList, i);
            if (maxDistance < totalDistance) {
                maxDistance = totalDistance;
            }

            totalDistance = getTotalDistanceStore(buildingList, i);
            if (maxDistance < totalDistance) {
                maxDistance = totalDistance;
            }

            System.out.println("totalDistance: " + totalDistance + ", result index: " + resultIndex);

            if (i == 0) {
                minDistance = maxDistance;
            } else {
                if (minDistance > maxDistance) {
                    minDistance = maxDistance;
                    resultIndex = i;
                }
            }

            System.out.println("maxTemp: " + minDistance + ", result index: " + resultIndex);
        }


//      with Array
//        int[] tmp = new int[buildingList.size()];
//
//        for (int i = 0; i < 5; i++) {
//            int totalDistance = 0;
//
//            totalDistance = getTotalDistanceGym(buildingList, i);
//            if (tmp[i] < totalDistance) {
//                tmp[i] = totalDistance;
//            }
//            totalDistance = getTotalDistanceSchool(buildingList, i);
//            if (tmp[i] < totalDistance) {
//                tmp[i] = totalDistance;
//            }
//
//            totalDistance = getTotalDistanceStore(buildingList, i);
//            if (tmp[i] < totalDistance) {
//                tmp[i] = totalDistance;
//            }
//        }
//
//        int resultIndex = 0;
//        int minDistance = buildingList.size();
//        for (int i = 0; i < tmp.length; i++) {
//            if (minDistance > tmp[i]) {
//                minDistance = tmp[i];
//                resultIndex = i;
//            }
//        }
//        System.out.println("minDistance: " + minDistance + ", result index: " + resultIndex);


    }

    private static int getTotalDistanceGym(List<Building> buildingList, int index) {

        // goto right;
        int step = 0;
        int totalDistance = 0;
        int tmpDistance = 0;
        int right = index;
        while (right < buildingList.size()) {
            Building building = buildingList.get(right);
            if (building.gym == true) {
                tmpDistance = step;
                break;
            }
            step++;
            right++;

        }
        if (tmpDistance > totalDistance) {
            totalDistance = tmpDistance;
        }

        // goto left;
        tmpDistance = 0;
        step = 0;
        int left = index;
        while (left > -1) {
            Building building = buildingList.get(left);
            if (building.gym == true) {
                tmpDistance = step;
                break;
            }
            step++;
            left--;
        }
        if (tmpDistance > totalDistance) {
            totalDistance = tmpDistance;
        }
        return totalDistance;
    }

    private static int getTotalDistanceSchool(List<Building> buildingList, int index) {

        // goto right;
        int step = 0;
        int totalDistance = 0;
        int tmpDistance = 0;
        int right = index;
        while (right < buildingList.size()) {
            Building building = buildingList.get(right);
            if (building.school == true) {
                tmpDistance = step;
                break;
            }
            step++;
            right++;

        }
        if (tmpDistance > totalDistance) {
            totalDistance = tmpDistance;
        }

        // goto left;
        tmpDistance = 0;
        step = 0;
        int left = index;
        while (left > -1) {
            Building building = buildingList.get(left);
            if (building.school == true) {
                tmpDistance = step;
                break;
            }
            step++;
            left--;
        }
        if (tmpDistance > totalDistance) {
            totalDistance = tmpDistance;
        }
        return totalDistance;
    }

    private static int getTotalDistanceStore(List<Building> buildingList, int index) {

        // goto right;
        int step = 0;
        int totalDistance = 0;
        int tmpDistance = 0;
        int right = index;
        while (right < buildingList.size()) {
            Building building = buildingList.get(right);
            if (building.store == true) {
                tmpDistance = step;
                break;
            }
            step++;
            right++;

        }
        if (tmpDistance > totalDistance) {
            totalDistance = tmpDistance;
        }

        // goto left;
        tmpDistance = 0;
        step = 0;
        int left = index;
        while (left > -1) {
            Building building = buildingList.get(left);
            if (building.store == true) {
                tmpDistance = step;
                break;
            }
            step++;
            left--;
        }
        if (tmpDistance > totalDistance) {
            totalDistance = tmpDistance;
        }
        return totalDistance;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Building {
    boolean gym;
    boolean school;
    boolean store;
}