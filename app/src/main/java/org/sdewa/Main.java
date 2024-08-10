package org.sdewa;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


import org.sdewa.AppContext.impl.AppContext;
import org.sdewa.entities.Product;
import org.sdewa.entities.impl.ProductDto;
import org.sdewa.menues.*;

import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.UserManagementServices;
import org.sdewa.services.impl.ProductManagementService;
import org.sdewa.services.impl.AuthManagementServices;

public class Main {


    public static void main(String[] args) {
        var context = AppContext.getInstance();
        context.putServices(new OrderManagementService(new ArrayList<>()));
        context.putServices(new UserManagementServices(new ArrayList<>()));
        context.putServices(new ProductManagementService(getInitProduct()));
        context.putServices(new AuthManagementServices());

        context.putMenu(AuthMenu::new);
        context.putMenu(ChangeEmailMenu::new);
        context.putMenu(ChangePasswordMenu::new);
        context.putMenu(CheckoutMenu::new);
        context.putMenu(CustomerListMenu::new);
        context.putMenu(MainMenu::new);
        context.putMenu(MyOrderMenu::new);
        context.putMenu(ProductCatalogMenu::new);
        context.putMenu(SettingMenu::new);
        context.putMenu(SettingMenu::new);
        context.putMenu(SignInMenu::new);
        context.putMenu(SignOutMenu::new);
        context.putMenu(SignUpMenu::new);

        context.runMenu(MainMenu.class);
    }


    private static List<Product> getInitProduct() {
        return new ArrayList<>(Arrays.asList(
                new ProductDto(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.99),
                new ProductDto(2, "Oregon Cottage Interior Oak Door", "Doors", 179.99),
                new ProductDto(3, "Oregon Cottage Horizontal Interior White Oak Door", "Doors", 189.99),
                new ProductDto(4, "4 Panel Oak Deco Interior Door", "Doors", 209.09),
                new ProductDto(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller", "Boilers", 989.99),
                new ProductDto(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP", "Boilers", 787.99),
                new ProductDto(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller", "Boilers", 859.99),
                new ProductDto(8, "Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)", "Bricks", 402.99),
                new ProductDto(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)", "Bricks", 659.99),
                new ProductDto(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368", "Bricks", 523.99)
        ));
    }
}