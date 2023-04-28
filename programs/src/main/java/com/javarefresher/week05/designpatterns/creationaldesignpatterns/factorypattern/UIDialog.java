package com.javarefresher.week05.designpatterns.creationaldesignpatterns.factorypattern;

// The creator class declares the factory method that must
// return an object of a product class. The creator's subclasses
// usually provide the implementation of this method.
abstract class Dialog {
    abstract Button createButton();
    public void render(){
        Button okButton = createButton();
        okButton.onClick();
        okButton.render();
    }
}
// Concrete creators override the factory method to change the
// resulting product's type.
class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog extends Dialog {
    @Override
    Button createButton() {
        return new WebButton();
    }
}


// The product interface declares the operations that all
// concrete products must implement.
interface Button{
    abstract void render();
    abstract void onClick();
}

class WindowsButton implements Button{

    @Override
    public void render() {
        System.out.println("Windows Button has been rendered successfully");
    }

    @Override
    public void onClick() {
        System.out.println("Windows Button has been clicked successfully");
    }
    
}

class WebButton implements Button{

    @Override
    public void render() {
        System.out.println("Web Button has been rendered successfully");
    }

    @Override
    public void onClick() {
        System.out.println("Web Button has been clicked successfully");
    }
}

class DialogFactory{
    public Dialog createDialog(String type){
        if (type == null || type.isEmpty())
            return null;
        switch (type) {
        case "Web":
            return new WebDialog();
        case "Windows":
            return new WindowsDialog();
        default:
            throw new IllegalArgumentException("Unknown type "+type);
        }
    }
}

public class UIDialog{
    public static void main(String[] args) {
        DialogFactory dialogFactory = new DialogFactory();
        Dialog dialog = dialogFactory.createDialog("Web");
        dialog.render();
    }
}