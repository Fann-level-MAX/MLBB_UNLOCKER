package mlbbunlocker.by.fann;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        } else {
            setContentView(R.layout.grant);
            Button btn = findViewById(R.id.btn_grant);
            btn.setText("Grant Root Access");
            btn.setOnClickListener(v -> {
                try {
                    Runtime.getRuntime().exec("su").destroy();
                } catch (Exception e) {}
            });
        }
    }

    @SuppressLint("SetTextI18n")
    private void init(){
        String _x436 = "";
        String _x294 = "";
        String _x943 = "";
        String _x704 = "";
        int hmUDq[] = { 0x004E, 0x004D, 0x0043, 0x0043, 0x0021, 0x0051, 0x0073, 0x0066, 0x0067, 0x0066 };
        for (int TkqbX = 0, MKhXw = 0; TkqbX < 10; TkqbX++) {
            MKhXw = hmUDq[TkqbX];
            MKhXw --;
            _x436 = _x436 + (char)(MKhXw & 0xFFFF);
        }
        int cgMZR[] = { 0x400E, 0xA00C, 0xC00D, 0x600C, 0xA00C, 0x600E, 0x0004, 0xA00C, 0x800C, 0x200D };
        for (int AsoRp = 0, oZwfh = 0; AsoRp < 10; AsoRp++) {
            oZwfh = cgMZR[AsoRp];
            oZwfh = ((oZwfh << 3) | ( (oZwfh & 0xFFFF) >> 13)) & 0xFFFF;
            _x943 = _x943 + (char)(oZwfh & 0xFFFF);
        }
        int eXfYh[] = { 0xFF8A, 0xFF90, 0xFF8E, 0xFFE1, 0xFFA0, 0xFF8A };
        for (int KQrLj = 0, FMkKj = 0; KQrLj < 6; KQrLj++) {
            FMkKj = eXfYh[KQrLj];
            FMkKj ++;
            FMkKj ^= 0xFFFF;
            FMkKj += KQrLj;
            _x294 = _x294 + (char)(FMkKj & 0xFFFF);
        }
        int uHdKE[] = { 0x0001, 0x7003, 0x3005, 0x1006, 0x2006, 0x5001 };
        for (int fWnax = 0, BKSLe = 0; fWnax < 6; fWnax++) {
            BKSLe = uHdKE[fWnax];
            BKSLe ++;
            BKSLe = (((BKSLe & 0xFFFF) >> 12) | (BKSLe << 4)) & 0xFFFF;
            BKSLe -= fWnax;
            _x704 = _x704 + (char)(BKSLe & 0xFFFF);
        }

        TextView cre = findViewById(R.id.cre);
        TextView dit = findViewById(R.id.dit);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dit.getLayoutParams();
        float scale = getResources().getDisplayMetrics().density;
        layoutParams.topMargin = (int) (6 * scale + 0.5f);
        cre.setText(_x436 + _x943 + _x294);
        cre.setTypeface(ResourcesCompat.getFont(this, R.font.cocon));
        cre.setLayoutParams(layoutParams);
        dit.setOnClickListener(v -> {
            Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();
        });
        dit.setText(_x704);
        dit.setTypeface(ResourcesCompat.getFont(this, R.font.cocon));
        dit.setTextColor(Color.parseColor("#EE0000"));
        dit.setTypeface(dit.getTypeface(), Typeface.BOLD_ITALIC);
        dit.setLayoutParams(layoutParams);
        init1();
    }

    private boolean isRooted() {
        String _x258 = "";
        int XhfMr[] = { 0x0073, 0x0074, 0x001E, 0x002A, 0x005F, 0x001B, 0x0063, 0x005D };
        for (int GYQBx = 0, KOCXH = 0; GYQBx < 8; GYQBx++) {
            KOCXH = XhfMr[GYQBx];
            KOCXH += GYQBx;
            _x258 = _x258 + (char)(KOCXH & 0xFFFF);
        }
        Process process;
        try {
            process = Runtime.getRuntime().exec(_x258);
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

    private void init1(){
        RadioGroup graphics = findViewById(R.id.graphics);
        RadioGroup fps = findViewById(R.id.fps);
        graphics.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checked = findViewById(checkedId);
            if (checked != null) {
                // TODO
                // PerformanceLv
            }
        });
        fps.setOnCheckedChangeListener(((group, checkedId) -> {
            RadioButton checked = findViewById(checkedId);
            if (checked != null) {
                // TODO
                // HighFpsMode
            }
        }));
    }
}