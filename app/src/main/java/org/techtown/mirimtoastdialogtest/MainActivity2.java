package org.techtown.mirimtoastdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textName,textEmail;//activity_main.xml
    EditText editName,editEmail;//dialog2.xml
    TextView textToast;//toast2.xml
    View dialogView,toastView;
    Button btnHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textName=findViewById(R.id.text_name2);
        textEmail=findViewById(R.id.text_email2);
        btnHere=findViewById(R.id.btn_here2);
        btnHere.setOnClickListener(btnHereListener);

    }
    View.OnClickListener btnHereListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            dialogView=View.inflate(MainActivity2.this,R.layout.dialog2,null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity2.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setIcon(R.drawable.one);
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인",positiveButtonListener);
            dlg.setNegativeButton("취소",negativeButtonListener);
            dlg.show();
        }
    };
    DialogInterface.OnClickListener positiveButtonListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            editName=dialogView.findViewById(R.id.edit_name2);
            editEmail=dialogView.findViewById(R.id.edit_email2);
            textName.setText(editName.getText().toString()+"님 안녕하세요.");
            textEmail.setText(editEmail.getText().toString()+" 이메일 주소입니다.");
        }
    };
    DialogInterface.OnClickListener negativeButtonListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast toast = new Toast(MainActivity2.this);
            toastView=View.inflate(MainActivity2.this,R.layout.toast2,null);
            //toast1에 루트까지 포함되어있기 때문에 그냥 null
            textToast=toastView.findViewById(R.id.text_toast2);
            textToast.setText("취소버튼을 누르셨네요.");
            toast.setView(toastView);
            toast.show();
        }
    };
}