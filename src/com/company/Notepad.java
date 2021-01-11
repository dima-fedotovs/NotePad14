package com.company;

import java.util.ArrayList;

public class Notepad {
    private final ArrayList<Record> records = new ArrayList<>();

    public void createRecord(RecordType recType) {
        var rec = recType.createRecord();
        rec.askData();
        records.add(rec);
        System.out.println("CREATED: " + rec);
    }

    public void listRecords() {
        for (Record rec : records) {
            System.out.println(rec);
        }
    }

    public void delete(int id) {
        var t = System.nanoTime();
//        for (int i = 0; i < records.size(); i++) {
//            var rec = records.get(i);
//            if (rec.getId() == id) {
//                records.remove(i);
//                break;
//            }
//        }
        records.removeIf(rec -> rec.getId() == id);
        System.out.println(System.nanoTime() - t);
    }

    public void findRecord(String substr) {
        var tmp = substr.toLowerCase();
        // OPTION 1
//        for (int i = 0; i < records.size(); i++) {
//            var rec = records.get(i);
//            if (rec.contains(tmp)) {
//                System.out.println(rec);
//            }
//        }
        // OPTION 2
//        for (Record rec : records) {
//            if (rec.contains(tmp)) {
//                System.out.println(rec);
//            }
//        }
        // OPTION 3
        records.stream()
                .filter(rec -> rec.contains(tmp))
                .forEach(rec -> System.out.println(rec));
    }


    public void listDue() {
        for (Record rec : records) {
            if (rec instanceof Scheduled) {
                Scheduled sc = (Scheduled) rec;
                if (sc.isDue()) {
                    System.out.println(sc);
                }
            }
        }
    }

    public void dismiss(int id) {
        for (Record rec : records) {
            if (rec instanceof Scheduled) {
                var sch = (Scheduled) rec;
                if (rec.getId() == id) {
                    sch.dismiss();
                    break;
                }
            }
        }
    }
}