package ua.lviv.iot.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.domain.City;
import ua.lviv.iot.domain.Client;
import ua.lviv.iot.domain.ClientCard;
import ua.lviv.iot.domain.Consultant;
import ua.lviv.iot.domain.Discount;
import ua.lviv.iot.domain.EntertainmentAgency;
import ua.lviv.iot.domain.Event;
import ua.lviv.iot.domain.Order;
import ua.lviv.iot.domain.PartyAnimator;
import ua.lviv.iot.domain.Region;

import ua.lviv.iot.controller.CityController;
import ua.lviv.iot.controller.ClientController;
import ua.lviv.iot.controller.ClientCardController;
import ua.lviv.iot.controller.ConsultantController;
import ua.lviv.iot.controller.DiscountController;
import ua.lviv.iot.controller.EntertainmentAgencyController;
import ua.lviv.iot.controller.EventController;
import ua.lviv.iot.controller.OrderController;
import ua.lviv.iot.controller.PartyAnimatorController;
import ua.lviv.iot.controller.RegionController;

import java.util.*;

@SuppressWarnings("DuplicatedCode")
@Component
public class View {
    @Autowired
    private CityController cityController;
    @Autowired
    private ClientCardController clientCardController;
    @Autowired
    private ClientController clientController;
    @Autowired
    private ConsultantController consultantController;
    @Autowired
    private DiscountController discountController;
    @Autowired
    private EntertainmentAgencyController entertainmentAgencyController;
    @Autowired
    private EventController eventController;
    @Autowired
    private OrderController orderController;
    @Autowired
    private PartyAnimatorController partyAnimatorController;
    @Autowired
    private RegionController regionController;


    private final Map<String, String> menu;
    private final Map<String, Printable> menuMethods;
    private final Scanner input = new Scanner(System.in);

    private final City nullCity = new City(null, null, null);
    private final Client nullClient = new Client(null, null, null, null, null);
    private final ClientCard nullClientCard = new ClientCard(null, null, null);
    private final Consultant nullConsultant = new Consultant(null, null, null, null, null);
    private final Discount nullDiscount = new Discount(null, null, null);
    private final EntertainmentAgency nullEntertainmentAgency = new EntertainmentAgency(null, null, null, null, null, null);
    private final Event nullEvent = new Event(null, null, null, null, null, null, null, null);
    private final Order nullOrder = new Order(null, null, null, null, null, null, null);
    private final PartyAnimator nullPartyAnimator = new PartyAnimator(null, null, null, null, null, null, null);
    private final Region nullRegion = new Region(null, null);

    public View() {
        menu = new LinkedHashMap<>();

        menu.put("AA", "AA - Select all tables");

        menu.put("01", "01 - Table: City");
        menu.put("011", "011 - Create City");
        menu.put("012", "012 - Update City");
        menu.put("013", "013 - Delete City");
        menu.put("014", "014 - Find all Cities");
        menu.put("015", "015 - Finds City by ID");

        menu.put("02", "02 - Table: Client");
        menu.put("021", "021 - Create Client");
        menu.put("022", "022 - Update Client");
        menu.put("023", "023 - Delete Client");
        menu.put("024", "024 - Find all Clients");
        menu.put("025", "025 - Find Client by ID");

        menu.put("03", "03 - Table: ClientCard");
        menu.put("031", "031 - Create ClientCard");
        menu.put("032", "032 - Update ClientCard");
        menu.put("033", "033 - Delete ClientCard");
        menu.put("034", "034 - Find all ClientCards");
        menu.put("035", "035 - Find ClientCard by ID");

        menu.put("04", "04 - Table: Consultant");
        menu.put("041", "041 - Create Consultant");
        menu.put("042", "042 - Update Consultant");
        menu.put("043", "043 - Delete Consultant");
        menu.put("044", "044 - Find all Consultants");
        menu.put("045", "045 - Find Consultant by ID");

        menu.put("05", "05 - Table: Discount");
        menu.put("051", "051 - Create Discount");
        menu.put("052", "052 - Update Discount");
        menu.put("053", "053 - Delete Discount");
        menu.put("054", "054 - Find all Discounts");
        menu.put("055", "055 - Find Discount by ID");

        menu.put("06", "06 - Table: EntertainmentAgency");
        menu.put("061", "061 - Create EntertainmentAgency");
        menu.put("062", "062 - Update EntertainmentAgency");
        menu.put("063", "063 - Delete EntertainmentAgency");
        menu.put("064", "064 - Find all EntertainmentAgencies");
        menu.put("065", "065 - Find EntertainmentAgency by ID");

        menu.put("07", "07 - Table: Event");
        menu.put("071", "071 - Create Event");
        menu.put("072", "072 - Update Event");
        menu.put("073", "073 - Delete Event");
        menu.put("074", "074 - Find all Events");
        menu.put("075", "075 - Find Event by ID");

        menu.put("08", "08 - Table: Order");
        menu.put("081", "081 - Create Order");
        menu.put("082", "082 - Update Order");
        menu.put("083", "083 - Delete Order");
        menu.put("084", "084 - Find all Orders");
        menu.put("085", "085 - Find Order by ID");

        menu.put("09", "09 - Table: PartyAnimator");
        menu.put("091", "091 - Create PartyAnimator");
        menu.put("092", "092 - Update PartyAnimator");
        menu.put("093", "093 - Delete PartyAnimator");
        menu.put("094", "094 - Find all PartyAnimators");
        menu.put("095", "095 - Find PartyAnimator by ID");

        menu.put("10", "10 - Table: Region");
        menu.put("101", "101 - Create Region");
        menu.put("102", "102 - Update Region");
        menu.put("103", "103 - Delete Region");
        menu.put("104", "104 - Find all Regions");
        menu.put("105", "105 - Find Region by ID");

        menu.put("EE", "EE - Exit");

        menuMethods = new LinkedHashMap<>();

        menuMethods.put("AA", this::selectAllTables);

        menuMethods.put("011", this::createCity);
        menuMethods.put("012", this::updateCity);
        menuMethods.put("013", this::deleteCity);
        menuMethods.put("014", this::findAllCities);
        menuMethods.put("015", this::findCityById);

        menuMethods.put("021", this::createClient);
        menuMethods.put("022", this::updateClient);
        menuMethods.put("023", this::deleteClient);
        menuMethods.put("024", this::findAllClients);
        menuMethods.put("025", this::findClientById);

        menuMethods.put("031", this::createClientCard);
        menuMethods.put("032", this::updateClientCard);
        menuMethods.put("033", this::deleteClientCard);
        menuMethods.put("034", this::findAllClientCards);
        menuMethods.put("035", this::findClientCardById);

        menuMethods.put("041", this::createConsultant);
        menuMethods.put("042", this::updateConsultant);
        menuMethods.put("043", this::deleteConsultant);
        menuMethods.put("044", this::findAllConsultants);
        menuMethods.put("045", this::findConsultantById);

        menuMethods.put("051", this::createDiscount);
        menuMethods.put("052", this::updateDiscount);
        menuMethods.put("053", this::deleteDiscount);
        menuMethods.put("054", this::findAllDiscounts);
        menuMethods.put("055", this::findDiscountById);

        menuMethods.put("061", this::createEntertainmentAgency);
        menuMethods.put("062", this::updateEntertainmentAgency);
        menuMethods.put("063", this::deleteEntertainmentAgency);
        menuMethods.put("064", this::findAllEntertainmentAgencies);
        menuMethods.put("065", this::findEntertainmentAgencyById);

        menuMethods.put("071", this::createEvent);
        menuMethods.put("072", this::updateEvent);
        menuMethods.put("073", this::deleteEvent);
        menuMethods.put("074", this::findAllEvents);
        menuMethods.put("075", this::findEventById);

        menuMethods.put("081", this::createOrder);
        menuMethods.put("082", this::updateOrder);
        menuMethods.put("083", this::deleteOrder);
        menuMethods.put("084", this::findAllOrders);
        menuMethods.put("085", this::findOrderById);

        menuMethods.put("091", this::createPartyAnimator);
        menuMethods.put("092", this::updatePartyAnimator);
        menuMethods.put("093", this::deletePartyAnimator);
        menuMethods.put("094", this::findAllPartyAnimators);
        menuMethods.put("095", this::findPartyAnimatorById);

        menuMethods.put("101", this::createRegion);
        menuMethods.put("102", this::updateRegion);
        menuMethods.put("103", this::deleteRegion);
        menuMethods.put("104", this::findAllRegions);
        menuMethods.put("105", this::findRegionById);
    }

    private void selectAllTables() {
        findAllCities();
        findAllClients();
        findAllClientCards();
        findAllConsultants();
        findAllDiscounts();
        findAllEntertainmentAgencies();
        findAllEvents();
        findAllOrders();
        findAllPartyAnimators();
        findAllRegions();
    }

    // ========================== City ==========================
    private void createCity() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'region_id': ");
        Integer regionId = Integer.valueOf(input.nextLine());

        City city = new City(null, name, regionId);

        int cnt = cityController.create(city);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateCity() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'region_id': ");
        Integer regionId = Integer.valueOf(input.nextLine());

        City city = new City(null, name, regionId);

        int cnt = cityController.update(id, city);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteCity() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = cityController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllCities() {
        System.out.println("\nTable: City");
        List<City> cities = cityController.findAll();

        for (City city : cities) {
            System.out.println(city);
        }
    }

    private void findCityById() {
        System.out.println("Input city 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<City> city = cityController.findById(id);
        System.out.println(city.orElse(nullCity));
    }

    // ========================== Client ==========================
    private void createClient() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'second_name': ");
        String secondName = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phoneNumber = input.nextLine();
        System.out.println("Input 'client_card_id': ");
        Integer clientCardId = Integer.valueOf(input.nextLine());

        Client client = new Client(null, firstName, secondName, phoneNumber, clientCardId);
        int cnt = clientController.create(client);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateClient() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'second_name': ");
        String secondName = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phoneNumber = input.nextLine();
        System.out.println("Input 'client_card_id': ");
        Integer clientCardId = Integer.valueOf(input.nextLine());

        Client client = new Client(null, firstName, secondName, phoneNumber, clientCardId);
        int cnt = clientController.update(id, client);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteClient() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = clientController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllClients() {
        System.out.println("\nTable: Client");
        List<Client> clients = clientController.findAll();
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void findClientById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Client> client = clientController.findById(id);
        System.out.println(client.orElse(nullClient));
    }

    // ========================== ClientCard ==========================
    private void createClientCard() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'discount_percentage': ");
        Integer discountPercentage = Integer.valueOf(input.nextLine());

        ClientCard clientCard = new ClientCard(null, name, discountPercentage);
        int cnt = clientCardController.create(clientCard);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateClientCard() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'discount_percentage': ");
        Integer discountPercentage = Integer.valueOf(input.nextLine());

        ClientCard clientCard = new ClientCard(null, name, discountPercentage);
        int cnt = clientCardController.update(id, clientCard);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteClientCard() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = clientCardController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllClientCards() {
        System.out.println("\nTable: ClientCard");
        List<ClientCard> clientCards = clientCardController.findAll();

        for (ClientCard clientCard : clientCards) {
            System.out.println(clientCard);
        }
    }

    private void findClientCardById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<ClientCard> clientCard = clientCardController.findById(id);
        System.out.println(clientCard.orElse(nullClientCard));
    }

    // ========================== Consultant ==========================
    private void createConsultant() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'second_name': ");
        String secondName = input.nextLine();
        System.out.println("Input 'phoneNumber': ");
        String phoneNumber = input.nextLine();
        System.out.println("Input 'entertainment_agency_id': ");
        Integer entertainmentAgencyId = Integer.valueOf(input.nextLine());

        Consultant consultant = new Consultant(null, firstName, secondName, phoneNumber, entertainmentAgencyId);
        int cnt = consultantController.create(consultant);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateConsultant() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'second_name': ");
        String secondName = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phoneNumber = input.nextLine();
        System.out.println("Input 'entertainment_agency_id': ");
        Integer entertainmentAgencyId = Integer.valueOf(input.nextLine());

        Consultant consultant = new Consultant(null, firstName, secondName, phoneNumber, entertainmentAgencyId);
        int cnt = consultantController.update(id, consultant);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteConsultant() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = consultantController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllConsultants() {
        System.out.println("\nTable: Consultant");
        List<Consultant> consultants = consultantController.findAll();

        for (Consultant consultant : consultants) {
            System.out.println(consultant);
        }
    }

    private void findConsultantById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Consultant> consultant = consultantController.findById(id);
        System.out.println(consultant.orElse(nullConsultant));
    }

    // ========================== Discount ==========================
    private void createDiscount() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'percentage': ");
        Integer percentage = Integer.valueOf(input.nextLine());

        Discount discount = new Discount(null, name, percentage);
        int cnt = discountController.create(discount);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateDiscount() {
        System.out.println("Input 'íd': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'percentage': ");
        Integer percentage = Integer.valueOf(input.nextLine());

        Discount discount = new Discount(null, name, percentage);
        int cnt = discountController.update(id, discount);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteDiscount() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = discountController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllDiscounts() {
        System.out.println("\nTable: Discount");
        List<Discount> discounts = discountController.findAll();

        for (Discount discount : discounts) {
            System.out.println(discount);
        }
    }

    private void findDiscountById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Discount> discount = discountController.findById(id);
        System.out.println(discount.orElse(nullDiscount));
    }

    // ========================== EntertainmentAgency ==========================
    private void createEntertainmentAgency() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'contact_number': ");
        String contactNumber = input.nextLine();
        System.out.println("Input 'address': ");
        String address = input.nextLine();
        System.out.println("Input 'animator_íd': ");
        Integer animatorId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'city_íd': ");
        Integer cityId = Integer.valueOf(input.nextLine());

        EntertainmentAgency entertainmentAgency = new EntertainmentAgency(null, name, contactNumber, address, animatorId, cityId);
        int cnt = entertainmentAgencyController.create(entertainmentAgency);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateEntertainmentAgency() {
        System.out.println("Input 'íd': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'contact_number': ");
        String contactNumber = input.nextLine();
        System.out.println("Input 'address': ");
        String address = input.nextLine();
        System.out.println("Input 'animator_íd': ");
        Integer animatorId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'city_íd': ");
        Integer cityId = Integer.valueOf(input.nextLine());

        EntertainmentAgency entertainmentAgency = new EntertainmentAgency(null, name, contactNumber, address, animatorId, cityId);
        int cnt = entertainmentAgencyController.update(id, entertainmentAgency);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteEntertainmentAgency() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = entertainmentAgencyController.delete(id);
        System.out.printf("There are %d deleted rows", cnt);
    }

    private void findAllEntertainmentAgencies() {
        System.out.println("\nTable: EntertainmentAgency");
        List<EntertainmentAgency> entertainmentAgencies = entertainmentAgencyController.findAll();

        for (EntertainmentAgency entertainmentAgency : entertainmentAgencies) {
            System.out.println(entertainmentAgency);
        }
    }

    private void findEntertainmentAgencyById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<EntertainmentAgency> entertainmentAgency = entertainmentAgencyController.findById(id);
        System.out.println(entertainmentAgency.orElse(nullEntertainmentAgency));
    }

    // ========================== Event ==========================
    private void createEvent() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'animators_num': ");
        Integer animators_num = Integer.valueOf(input.nextLine());
        System.out.println("Input 'visitors_num': ");
        Integer visitors_num = Integer.valueOf(input.nextLine());
        System.out.println("Input 'date': ");
        String date = input.nextLine();
        System.out.println("Input 'address': ");
        String address = input.nextLine();
        System.out.println("Input 'duration_in_hours': ");
        Integer durationInHours = Integer.valueOf(input.nextLine());
        System.out.println("Input 'city_íd': ");
        Integer cityId = Integer.valueOf(input.nextLine());

        Event event = new Event(null, name, animators_num, visitors_num, date, address, durationInHours, cityId);
        int cnt = eventController.create(event);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateEvent() {
        System.out.println("Input 'íd': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'animators_num': ");
        Integer animators_num = Integer.valueOf(input.nextLine());
        System.out.println("Input 'visitors_num': ");
        Integer visitors_num = Integer.valueOf(input.nextLine());
        System.out.println("Input 'date': ");
        String date = input.nextLine();
        System.out.println("Input 'address': ");
        String address = input.nextLine();
        System.out.println("Input 'duration_in_hours': ");
        Integer durationInHours = Integer.valueOf(input.nextLine());
        System.out.println("Input 'city_íd': ");
        Integer cityId = Integer.valueOf(input.nextLine());

        Event event = new Event(null, name, animators_num, visitors_num, date, address, durationInHours, cityId);
        int cnt = eventController.update(id, event);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteEvent() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = eventController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllEvents() {
        System.out.println("\nTable: Event");
        List<Event> events = eventController.findAll();

        for (Event event : events) {
            System.out.println(event);
        }
    }

    private void findEventById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Event> event = eventController.findById(id);
        System.out.println(event.orElse(nullEvent));
    }

    // ========================== Order ==========================
    private void createOrder() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'cost_in_usd': ");
        Integer costInUsd = Integer.valueOf(input.nextLine());
        System.out.println("Input 'event_id': ");
        Integer eventId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'discount_id': ");
        Integer discountId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'client_id': ");
        Integer clientId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'entertainment_agency_íd': ");
        Integer entertainmentAgencyId = Integer.valueOf(input.nextLine());

        Order order = new Order(null, name, costInUsd, eventId, discountId, clientId, entertainmentAgencyId);
        int cnt = orderController.create(order);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateOrder() {
        System.out.println("Input 'íd': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'cost_in_usd': ");
        Integer costInUsd = Integer.valueOf(input.nextLine());
        System.out.println("Input 'event_id': ");
        Integer eventId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'discount_id': ");
        Integer discountId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'client_id': ");
        Integer clientId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'entertainment_agency_íd': ");
        Integer entertainmentAgencyId = Integer.valueOf(input.nextLine());

        Order order = new Order(null, name, costInUsd, eventId, discountId, clientId, entertainmentAgencyId);
        int cnt = orderController.update(id, order);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteOrder() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = orderController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllOrders() {
        System.out.println("\nTable: Order");
        List<Order> orders = orderController.findAll();

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private void findOrderById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Order> order = orderController.findById(id);
        System.out.println(order.orElse(nullOrder));
    }

    // ========================== PartyAnimator ==========================
    private void createPartyAnimator() {
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'second_name': ");
        String secondName = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phoneNumber = input.nextLine();
        System.out.println("Input 'unique_performance': ");
        String uniquePerformance = input.nextLine();
        System.out.println("Input 'work_experience_in_years': ");
        Integer workExperienceInYears = Integer.valueOf(input.nextLine());
        System.out.println("Input 'order_id': ");
        Integer orderId = Integer.valueOf(input.nextLine());

        PartyAnimator partyAnimator = new PartyAnimator(null, firstName, secondName, phoneNumber, uniquePerformance, workExperienceInYears, orderId);
        int cnt = partyAnimatorController.create(partyAnimator);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updatePartyAnimator() {
        System.out.println("Input 'íd': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'first_name': ");
        String firstName = input.nextLine();
        System.out.println("Input 'second_name': ");
        String secondName = input.nextLine();
        System.out.println("Input 'phone_number': ");
        String phoneNumber = input.nextLine();
        System.out.println("Input 'unique_performance': ");
        String uniquePerformance = input.nextLine();
        System.out.println("Input 'work_experience_in_years': ");
        Integer workExperienceInYears = Integer.valueOf(input.nextLine());
        System.out.println("Input 'order_id': ");
        Integer orderId = Integer.valueOf(input.nextLine());

        PartyAnimator partyAnimator = new PartyAnimator(null, firstName, secondName, phoneNumber, uniquePerformance, workExperienceInYears, orderId);
        int cnt = partyAnimatorController.update(id, partyAnimator);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deletePartyAnimator() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = partyAnimatorController.delete(id);
        System.out.printf("There are %d deleted rows", cnt);
    }

    private void findAllPartyAnimators() {
        System.out.println("\nTable: PartyAnimator");
        List<PartyAnimator> partyAnimators = partyAnimatorController.findAll();

        for (PartyAnimator partyAnimator : partyAnimators) {
            System.out.println(partyAnimator);
        }
    }

    private void findPartyAnimatorById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<PartyAnimator> partyAnimator = partyAnimatorController.findById(id);
        System.out.println(partyAnimator.orElse(nullPartyAnimator));
    }

    // ========================== Region ==========================
    private void createRegion() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Region region = new Region(null, name);
        int cnt = regionController.create(region);
        System.out.printf("There are %d created rows\n", cnt);
    }

    private void updateRegion() {
        System.out.println("Input 'íd': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Region region = new Region(null, name);
        int cnt = regionController.update(id, region);
        System.out.printf("There are %d updated rows\n", cnt);
    }

    private void deleteRegion() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int cnt = regionController.delete(id);
        System.out.printf("There are %d deleted rows\n", cnt);
    }

    private void findAllRegions() {
        System.out.println("\nTable: Region");
        List<Region> regions = regionController.findAll();

        for (Region region : regions) {
            System.out.println(region);
        }
    }

    private void findRegionById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Region> region = regionController.findById(id);
        System.out.println(region.orElse(nullRegion));
    }

    private void outputMenu() {
        System.out.println("\nMenu: ");

        for (String key : menu.keySet()) {
            if (key.length() == 2) {
                System.out.println(menu.get(key));
            }
        }
    }

    private void outputSubmenu(String fig) {
        System.out.println("\nSubmenu: ");

        for (String key : menu.keySet()) {
            if (key.length() != 2 && key.substring(0, 2).equals(fig)) {
                System.out.println(menu.get(key));
            }
        }
    }

    public void show() {
        String menuKey;

        do {
            outputMenu();
            System.out.println("Please, select menu point");
            menuKey = input.nextLine().toUpperCase();

            if (menuKey.matches("^\\d\\d")) {
                outputSubmenu(menuKey);
                System.out.println("Please, select submenu point");
                menuKey = input.nextLine().toUpperCase();
            }

            try {
                menuMethods.get(menuKey).print();
            } catch (Exception e) {
                e.printStackTrace(); // Printing detailed info about exception
            }
        } while (!menuKey.equals("E"));
    }
}
