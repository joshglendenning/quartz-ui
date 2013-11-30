package pebbleUI.compiler;

import pebbleUI.compiler.Line;

/**
 * @author joshglendenning
 */
public class UITree {

	//=== Properties ===============//

	UINode root;

	//=== Constructors =============//

	public UITree(UINode root) {
		this.root = root;
	}

	//=== Methods ==================//

	public String compile() {
		return 
			root.getDeclarations()
			+ "static void ui_load(void) {" + Line.newline()
			+ root.create(null)
			+ "}" + Line.newline()
			+ "static void ui_unload(void) {" + Line.newline()
			+ root.destroy(null)
			+ "}";
	}

}
