package tunisStore.app

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SeConnecter : AppCompatActivity() {

    private lateinit var passwordEditText: EditText
    private lateinit var eyeImageView: ImageView
    private var passwordVisible = false

    override fun    onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.se_connecter)

        passwordEditText = findViewById(R.id.editTextPassword)
        eyeImageView = findViewById(R.id.eyeIcon)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val btnretour = findViewById<TextView>(R.id.btnRetour)

        buttonLogin.setOnClickListener {
            Toast.makeText(this, "Bouton cliqué", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AccueilActivity::class.java)
            startActivity(intent)
        }

        btnretour.setOnClickListener {
            val intent = Intent(this, Bienvenue::class.java)
            startActivity(intent)
        }

        eyeImageView.setOnClickListener {
            passwordVisible = !passwordVisible
            if (passwordVisible) {
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                eyeImageView.setImageResource(R.drawable.ic_eye)
            } else {
                passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                eyeImageView.setImageResource(R.drawable.ic_eye_closed)
            }
            passwordEditText.setSelection(passwordEditText.text.length)
        }

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            // TODO: logique de connexion
        }

        findViewById<Button>(R.id.buttonGoogleLogin).setOnClickListener {
            // TODO: logique de connexion Google
        }

        findViewById<TextView>(R.id.linkSignup).setOnClickListener {
            // TODO: redirection vers page inscription
        }

        findViewById<TextView>(R.id.forgotPassword).setOnClickListener {
            // TODO: redirection vers mot de passe oublié
        }
    }

    fun onRetourClick(view: View) {
        finish()
    }

    fun onTogglePasswordVisibility(view: View) {
        eyeImageView.performClick()
    }
}
