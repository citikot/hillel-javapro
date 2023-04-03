package facade;

public class MainFacade {
    public static void main(String[] args) {
        HotelCuisine hotelCuisine = new HotelCuisine();
        System.out.println("Menu: " + hotelCuisine.getMenus());
        System.out.println("Vines: " + hotelCuisine.getVineCard());
    }
}
