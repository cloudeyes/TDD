package com.tdd.testability;

import java.util.ArrayList;
import java.util.List;

public class OCP {

  public static class OriginalMenuSystem extends MenuSystem {

    public void drawMenus() {
      // ... lots of code ...
      initBrazilMenu();

      // Drawing a Brazil menu
      String brazilMenuText = "Brazil Menu";

      if (isValidMenuText(brazilMenuText)) {
        paintBrazil(brazilMenuText);
      }

      // Drawing a Pipelines menu
      preparePipelinesMenu();

      String pipelinesMenuText = "Pipelines Menu";

      if (isValidMenuText(pipelinesMenuText)) {
        drawPipelinesMenu(pipelinesMenuText);
      }
      // ... lots of code ...
    }

    private void initBrazilMenu() {
      // ... do some work ...
    }

    private void paintBrazil(String text) {
      System.out.println(String.format("Inserting a menu item: %s", text));
    }

    private void preparePipelinesMenu() {
      // ... do some work ...
    }

    private void drawPipelinesMenu(String text) {
      System.out.println(String.format("Inserting a menu item: %s", text));
    }
  }

  public static class InitialMenuSystem extends MenuSystem {

    public List<MenuItem> getMenuItems() {
      return List.of(new MenuItem("BrazilMenu"), new MenuItem("Pipeline Menu"));
    }

    public void drawMenus() {
      for (MenuItem menuItem : this.getMenuItems()) {
        menuItem.init();
        if (isValidMenuText(menuItem.getMenuText())) {
          menuItem.draw();
        }
      }
    }
  }

  public static class EnhancedMenuSystem extends InitialMenuSystem {
    List<MenuItem> _menuItems = new ArrayList<>();

    public EnhancedMenuSystem(List<MenuItem> menuItems) {
      this._menuItems.addAll(menuItems);
    }

    @Override
    public List<MenuItem> getMenuItems() {
      return this._menuItems;
    }
  }

  public abstract static class MenuSystem {
    public boolean isValidMenuText(String text) {
      return text.length() < 99;
    }

    public abstract void drawMenus();
  }

  public static class MenuItem {
    String _menuText;

    public MenuItem(String menuText) {
      this._menuText = menuText;
    }

    public String getMenuText() {
      return this._menuText;
    }

    public void init() {}

    public void draw() {}
  }
}
