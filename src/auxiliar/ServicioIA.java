// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package auxiliar;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;
import com.google.genai.types.ThinkingConfig;

public class ServicioIA {

    public static String LlamarIA(String informacion) {
        // Tomar API KEY desde variable de entorno
        String apiKey = System.getenv("ERP_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            return "ERROR: La variable de entorno no está configurada.";
        }

        // The client gets the API key from the environment variable `GEMINI_API_KEY`.
        Client client = new Client.Builder().apiKey(apiKey).build();

        GenerateContentConfig config
                = GenerateContentConfig.builder()
                        .systemInstruction(Content.fromParts(Part.fromText("Eres un asistente experto en análisis organizacional dentro de un sistema ERP. \n"
                                + "Tu tarea es analizar el perfil de un empleado y las características de dos áreas de una empresa, \n"
                                + "y elaborar un reporte claro, profesional y equilibrado con:\n"
                                + "\n"
                                + "- Ventajas del movimiento del empleado hacia el área destino.\n"
                                + "- Desventajas o posibles riesgos.\n"
                                + "- Consideraciones adicionales relevantes para la toma de decisiones.\n"
                                + "\n"
                                + "El reporte debe ser breve, concreto y no debe inventar datos.\n"
                                + "Solo utiliza la información proporcionada en el prompt del usuario."
                                + "No uses asteriscos ni ningun caracter que implique tipos de letra como negrita, cursiva, titulos, etc")))
                        .thinkingConfig(ThinkingConfig.builder().thinkingBudget(0))
                        .build();

        GenerateContentResponse response
                = client.models.generateContent(
                        "gemini-2.5-flash",
                        informacion,
                        config);

        return response.text();
    }
}
