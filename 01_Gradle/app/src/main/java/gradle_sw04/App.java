/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package gradle_sw04;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.elements.PseudoText;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        Render render = new Render();
		render.setPseudoCanvas(true);
		IContextBuilder builder = render.newBuilder();
		builder.width(120).height(20);
		builder.element(new PseudoText("PseudoText", false));
		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);

        System.out.println(new App().getGreeting());
    }
}
