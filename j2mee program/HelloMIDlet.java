package hello;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*; 
public class HelloMIDlet extends MIDlet implements CommandListener
{
 private Form form;
 private Display display;
 private TextField input1, input2;
 private Command add, sub, mul,div;
 private StringItem item;

 public HelloMIDlet()
 {

 }
 public void startApp()
 {
  display = Display.getDisplay(this);
  Form form = new Form("Calculator");
  form.append("My Calculator");
  item = new StringItem("Result", "");

  input1 = new TextField("First Number:", "", 30, TextField.NUMERIC);
  input2 = new TextField("Second Number", "", 30, TextField.NUMERIC);
  form.append(input1);
  form.append(input2);
  StringItem button = new StringItem("", "ADD", Item.BUTTON);
Command buttonCommand = new Command("Button command", Command.ITEM, 1);
button.setDefaultCommand(buttonCommand);
button.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
calculate();
}
});
form.append(button);

StringItem button1 = new StringItem("", "SUB", Item.BUTTON);
Command buttonCommand1 = new Command("Button command", Command.ITEM, 1);
button1.setDefaultCommand(buttonCommand);
button1.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
calculate1();
}
});
form.append(button1);

StringItem button2 = new StringItem("", "MUL", Item.BUTTON);
Command buttonCommand2 = new Command("Button command", Command.ITEM, 1);
button2.setDefaultCommand(buttonCommand);
button2.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
calculate2();
}
});
form.append(button2);
StringItem button3 = new StringItem("", "DIV", Item.BUTTON);
Command buttonCommand3 = new Command("Button command", Command.ITEM, 1);
button3.setDefaultCommand(buttonCommand);
button3.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
calculate3();
}
});
form.append(button3);
StringItem button4 = new StringItem("", "Clear", Item.BUTTON);
Command buttonCommand4 = new Command("Button command", Command.ITEM, 1);
button4.setDefaultCommand(buttonCommand);
button4.setItemCommandListener(new ItemCommandListener() {
public void commandAction(Command c, Item item) {
input1.setString("");
input2.setString("");
}
});
form.append(button4);

  add = new Command("Addition", Command.OK, 1);
  sub = new Command("Subtraction", Command.OK, 1);
  mul = new Command("Multiplication", Command.OK, 1);
  div = new Command("Division", Command.OK, 1);
  form.addCommand(add);
  form.addCommand(sub);
  form.addCommand(mul);
  form.addCommand(div);
  form.append(item);

  form.setCommandListener(this);

  display.setCurrent(form);
 }

 public void pauseApp() { }

 public void destroyApp(boolean uncondn)
 {
  notifyDestroyed();
 }
    private void calculate()
 {int one=Integer.parseInt(input1.getString());
  int two= Integer.parseInt(input2.getString());
  int result=one+two;
  item.setText( result + "" );

 }
 private void calculate1()
 {
  int one = Integer.parseInt(input1.getString());
  int two = Integer.parseInt(input2.getString());
  int result = one - two;
  item.setText(result + "");

 }
 private void calculate2()
 {
  int one = Integer.parseInt(input1.getString());
  int two = Integer.parseInt(input2.getString());
  int result = one * two;
  item.setText(result + "");

 }
 private void calculate3()
 {
  int one = Integer.parseInt(input1.getString());
  int two = Integer.parseInt(input2.getString());
  int result = one / two;
  item.setText(result + "");

 }
 public void commandAction(Command c, Displayable d)
 {
  String label = c.getLabel();
  if (label.equals("Addition"))
  {
   calculate();

  }

  else if (label.equals("Subtraction"))
  {
   calculate1();

  }

  else if (label.equals("Multiplication"))
  {
   calculate2();
   form.append("The Answer is:");
  }

  else if (label.equals("Division"))
  {
   calculate3();
   form.append("The Answer is:");
  }
 }
}
