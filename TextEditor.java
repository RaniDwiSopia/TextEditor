import java.util.Stack;

public class TextEditor {
    private StringBuilder text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        this.text = new StringBuilder();
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void show() {
        System.out.println("Teks saat ini: " + text.toString());
    }

    public void write(String newText) {
        undoStack.push(text.toString());
        redoStack.clear();
        text.append(newText);
        System.out.println("Teks ditambahkan: " + newText);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pop());
            System.out.println("Undo dilakukan.");
        } else {
            System.out.println("Tidak ada aksi yang dapat di-undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text.toString());
            text = new StringBuilder(redoStack.pop());
            System.out.println("Redo dilakukan.");
        } else {
            System.out.println("Tidak ada aksi yang dapat di-redo.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Contoh penggunaan
        editor.write("Halo, ");
        editor.show();

        editor.write("ini adalah ");
        editor.show();

        editor.write("mata kuliah pemrograman mahir.");
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();

        editor.undo();
        editor.undo();
        editor.show();

        editor.redo();
        editor.show();
    }
}
