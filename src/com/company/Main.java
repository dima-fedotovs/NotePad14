package com.company;

public class Main {
    private static Notepad notepad = new Notepad();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            var cmd = InputUtils.askString("Enter command");
            switch (cmd) {
                case "list":
                    listRecords();
                    break;
                case "create":
                    createRecord();
                    break;
                case "delete":
                    deleteRecord();
                    break;
                case "find":
                    findRecord();
                    break;
                case "due":
                    listDue();
                    break;
                case "dismiss":
                    dismiss();
                    break;
                case "help":
                    showHelp();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        System.out.println("Good bye!");
    }

    private static void dismiss() {
        int id = InputUtils.askInt("ID");
        notepad.dismiss(id);
    }

    private static void listDue() {
        notepad.listDue();
    }

    private static void findRecord() {
        var substr = InputUtils.askString("Substring to find");
        notepad.findRecord(substr);
    }

    private static void deleteRecord() {
        int id = InputUtils.askInt("ID");
        notepad.delete(id);
    }

    private static void listRecords() {
        notepad.listRecords();
    }

    private static void createRecord() {
        var strType = InputUtils.askString("Type");
        var type = RecordType.valueOf(strType);
        notepad.createRecord(type);
    }

    private static void showHelp() {
        System.out.println("This is very helpful help");
    }
}
