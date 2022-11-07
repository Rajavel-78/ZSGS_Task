package urlConnection;

//java Program to create a simple JList
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class Solve extends JFrame {
	static JFrame frame;
	static JList b;

	public void swingDisplay(ArrayList<Datum> customerDetails) {

		frame = new JFrame("frame");
		Solve s = new Solve();
		JPanel panal = new JPanel();

		for (int index = 0; index < customerDetails.size(); index++) {
			Object[] arr1 = { customerDetails.get(index).getId(), customerDetails.get(index).getName(),
					customerDetails.get(index).getClass(), customerDetails.get(index).getColor(),
					customerDetails.get(index).getPantone_value() };

			b = new JList(arr1);
			panal.add(b);
			frame.add(panal);
		}

		frame.setSize(1000, 1000);

		frame.show();
		frame.setDefaultCloseOperation(ERROR);
	}

}