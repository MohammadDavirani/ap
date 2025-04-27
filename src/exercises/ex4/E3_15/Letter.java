package exercises.ex4.E3_15;

import javax.sound.sampled.Line;

public class Letter {
    private String sender;
    private String recipient;
    private String Letter;

    public Letter(String from, String to){
        this.sender = from;
        this.recipient = to;
        this.Letter = String.format("Dear %s:\n",recipient);
    }
    public void addLine(String line) {
        Letter = Letter.concat(line).concat("\n");
    }

    public String getText(){
        String text = "";
        text = text.concat("Dear ").concat(recipient).concat(":\n\n");
        text = text.concat(Letter).concat("\n");
        text = text.concat("Sincerely,\n\n");
        text = text.concat(sender);
        return text;
    }

}
