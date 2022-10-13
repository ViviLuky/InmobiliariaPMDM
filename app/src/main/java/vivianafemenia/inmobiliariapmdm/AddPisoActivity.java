package vivianafemenia.inmobiliariapmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import vivianafemenia.inmobiliariapmdm.databinding.ActivityAddPisoBinding;
import vivianafemenia.inmobiliariapmdm.modelo.Piso;

public class AddPisoActivity extends AppCompatActivity {

    private ActivityAddPisoBinding binding;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddPisoBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

       ratingBar=(RatingBar)findViewById(R.id.rbValPiso);
       ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               Toast.makeText(AddPisoActivity.this, "Tu Valoración es :"+ratingBar, Toast.LENGTH_SHORT).show();
           }
       });

        binding.btnAgregarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Piso pisomodelo=agregarPiso();
                if(pisomodelo!=null){

                    Bundle bundle=new Bundle();
                    bundle.putParcelable("PISO",pisomodelo);
                    Intent intent=new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }else {
                    Toast.makeText(AddPisoActivity.this, "Faltan Campos por Rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Piso agregarPiso() {
        if(binding.lblCallePiso.getText().toString().isEmpty()|| binding.lblNumeroPiso.getText().toString().isEmpty()
                ||binding.lblProvinciaPiso.getText().toString().isEmpty())
        return null;
        if(!binding.rbValPiso.isIndicator())
            return null;

        return new Piso(binding.lblCallePiso.toString(),binding.lblNumeroPiso.toString(),binding.lblProvinciaPiso.toString(),binding.rbValPiso.toString());
    }
}