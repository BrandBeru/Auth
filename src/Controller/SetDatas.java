package Controller;

import Values.Datas;

import javax.swing.*;

public class SetDatas {
    public void SetLabels(JLabel label){
        label.setText(Datas.getActiveRole().toString());
    }
    public void SetLabels(JLabel... labels){
        String texts[] = {Datas.getActiveRole().getName(), Datas.getActiveRole().getEmail(), Datas.getActiveRole().getAddress(), Datas.getActiveRole().getPhoneNumber(), Datas.getActiveRole().getRole()};
        int i = 0;
        for(JLabel label : labels){
            label.setText(label.getText()+": "+texts[i]);
            i++;
        }
    }
}
