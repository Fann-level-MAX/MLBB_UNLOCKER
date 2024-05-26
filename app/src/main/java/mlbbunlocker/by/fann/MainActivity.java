package mlbbunlocker.by.fann;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isRooted()) {
            setContentView(R.layout.main);
            init();
        }
    }

    public static String getString(int[] data) {
        StringBuffer test = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int t = data[i] >> 3;
            test.append((char) t);
        }
        return test.toString();
    }

    private void init(){
        TextView cre = findViewById(R.id.cre);
        TextView dit = findViewById(R.id.dit);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dit.getLayoutParams();
        float scale = getResources().getDisplayMetrics().density;
        int marginTopInPx = (int) (6 * scale + 0.5f);
        layoutParams.topMargin = marginTopInPx;
        cre.setText("MLBB Preferences editor by");
        cre.setTypeface(ResourcesCompat.getFont(this, R.font.cocon));
        dit.setText(" @Fann_27");
        dit.setTypeface(ResourcesCompat.getFont(this, R.font.cocon));
        dit.setTextColor(Color.parseColor("#0000EE"));
        dit.setTypeface(dit.getTypeface(), Typeface.BOLD_ITALIC);
        dit.setLayoutParams(layoutParams);
    }

    private boolean isRooted() {
        Process process;
        try {
            process = Runtime.getRuntime().exec("su -c id");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            reader.close();
            process.destroy();
            return output != null && output.contains("uid=0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}