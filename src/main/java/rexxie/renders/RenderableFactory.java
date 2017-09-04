package rexxie.renders;

public  class RenderableFactory {
   public Renderable getRender(Renderers renderers) {
      switch (renderers) {
         case CONSOLE: return new ConsoleGridRenderer();

         default: return new ConsoleGridRenderer();
      }
   }
}
