package vivianafemenia.inmobiliariapmdm;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;


import vivianafemenia.inmobiliariapmdm.databinding.ActivityMainBinding;
import vivianafemenia.inmobiliariapmdm.modelo.Piso;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> addPisoLaucher;
    private ArrayList<Piso> pisoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        pisoArrayList=new ArrayList<>();
        inicializarLaucher();


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             addPisoLaucher.launch(new Intent(MainActivity.this,AddPisoActivity.class));
            }
        });
    }

    private void inicializarLaucher() {
        addPisoLaucher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                      if(result.getResultCode()==RESULT_OK){
                         if(result.getData()!=null && result.getData().getExtras()!=null){
                             Piso piso=result.getData().getExtras().getParcelable("PISO");
                             if(piso!=null){
                                 pisoArrayList.add(piso);
                                 mostrarPiso();
                             }
                         }
                     }
                    }
                }
        );
    }

    private void mostrarPiso(){
        binding.contentMain.contenedorMain.removeAllViews();
        for (Piso piso: pisoArrayList) {
            LayoutInflater layoutInflater=LayoutInflater.from(MainActivity.this);
            View pisoView= layoutInflater.inflate(R.layout.piso_modelo_view,null);
            TextView txtCalle=pisoView.findViewById(R.id.lblCallePisoView);
            TextView txtNumero=pisoView.findViewById(R.id.lblNumeroPisoView);
            TextView txtProvincia=pisoView.findViewById(R.id.lblProvinciaPisoView);

            txtCalle.setText(piso.getDireccion());
            txtNumero.setText(piso.getNumero());
            txtProvincia.setText(piso.getProvincia());
            binding.contentMain.contenedorMain.addView(pisoView);
        }
    }

}


