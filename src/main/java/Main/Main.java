/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Controller.LaundryController;
import View.LaundryView;

/**
 *
 * @author ADVAN
 */
public class Main {

    public static void main(String[] args) {

        LaundryController controller =
                new LaundryController();

        LaundryView view =
                new LaundryView(controller);

        view.mulai();
    }
}