QuartzUI
========

Java command line application to compile UI XML files into a pebble header file for initialization.

Purpose
=======

Initializing and setting basic properties for Pebble UI elements can be cumbersome and annoying, especially in C. QuartzUI offers a way for lazy Pebble developers to generate code for their UI from a more readable XML file, allowing for more readable code and easier maintainence.

Usage
=====

You can run QuartzUI with the following command:
`java -jar 'PATH_TO_QUARTZ_DIST/QuartzUI.jar' ui.xml`

### Step-by-Step
1. Create your Pebble project normally with `pebble new-project`
2. Create a *ui.xml* in the root folder of your project. (See *examples/ui.xml* for help.)
3. Write your ui.xml.
    Current the only tags that are availible are *window* and *text_layer*. You must use a window as the root element of the file, which should be pushed to the screen in your *init()* function. All elements MUST have an *id* attribute.
5. Include *ui.h*. (`#include <ui.h>`)
    QuartzUI will "compile" your ui.xml into *src/ui.h*, which will initialize all of the defined UI elements. All elements can be referenced by the id given to them by the *id* attribute.
6. Call *ui_load()* in your *init()* function and *ui_unload()* in your *deinit()* function.

Example
=======

ui.xml:
```
<window
    id="parent_window"
    bg-color="black"
    fullscreen="false"
    >
    <text_layer
        id="example_text_layer"
        font="GOTHIC_18"
        text-align="center"
        theme="dark"
        y="50"
        width="100%"
        height="50"
        />
</window>
```
app.c:
```
#include <pebble.h>
#include <ui.h>

static void init(void) {
    ui_load();
    text_layer_set_text(example_text_layer, "Hello, world!");
    window_stack_push(parent_window, true);
}

static void deinit(void) {
    ui_unload();
}

int main(void) {
  init();
  app_event_loop();
  deinit();
}
```
