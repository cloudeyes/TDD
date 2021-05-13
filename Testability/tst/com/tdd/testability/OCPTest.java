/*
Open/Closed Principle: https://en.wikipedia.org/wiki/Open/closed_principle

Definition: Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

Context: We are writing an IDE for Amazon. It has a menu system to draw menus such as "File", "Edit", etc. Currently
we have one method in the MenuSystem class of the IDE to draw menus.

Goal: Implement givenMultipeMenuItems_whenDrawMenus_thenTheImplemenetationOfDrawMenusDoesntChange.
*/
package com.tdd.testability;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.tdd.testability.OCP.EnhancedMenuSystem;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OCPTest {
  @Test
  public void givenMenuSystem_whenIsValidMenuText_thenReturnsTrue() {
    // GIVEN
    OCP.MenuSystem menuSystem = new OCP.OriginalMenuSystem();

    // WHEN
    boolean validMenuText = menuSystem.isValidMenuText("Menu Item 1");

    // THEN
    assertTrue(validMenuText);
  }

  // Given: A MenuSystem that knows about multiple menu items
  // When: We draw menus
  // Then: drawMenus() is closed to modification, but open to extension
  @Test
  public void givenMultipeMenuItems_whenDrawMenus_thenTheImplemenetationOfDrawMenusDoesntChange()
      throws NoSuchMethodException {
    // GIVEN
    final OCP.MenuItem menuItemDouble1 = Mockito.mock(OCP.MenuItem.class);
    final OCP.MenuItem menuItemDouble2 = Mockito.mock(OCP.MenuItem.class);

    OCP.MenuSystem originalMenuSystem = new OCP.InitialMenuSystem();
    OCP.MenuSystem newMenuSystem =
        new EnhancedMenuSystem(List.of(menuItemDouble1, menuItemDouble2));

    // WHEN
    Mockito.when(menuItemDouble1.getMenuText()).thenReturn("menuItem1");
    Mockito.when(menuItemDouble2.getMenuText()).thenReturn("menuItem2");

    originalMenuSystem.drawMenus();
    newMenuSystem.drawMenus();
    // THEN

    // 1. `drawMenus` implementation is not changed.
    assertEquals(
        OCP.InitialMenuSystem.class,
        OCP.EnhancedMenuSystem.class.getMethod("drawMenus").getDeclaringClass());

    // 2. `menuItems` are correctly processed.
    Mockito.verify(menuItemDouble1).init();
    Mockito.verify(menuItemDouble1).draw();

    Mockito.verify(menuItemDouble2).init();
    Mockito.verify(menuItemDouble2).draw();
  }
}
