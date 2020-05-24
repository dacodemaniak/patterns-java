package fr.ideafactory.pattern;

import fr.ideafactory.pattern.factory.BadFactory;
import fr.ideafactory.pattern.factory.CharacterFactory;
import fr.ideafactory.pattern.factory.FactoryProvider;
import fr.ideafactory.pattern.factory.HeroFactory;
import fr.ideafactory.pattern.models.Armour;
import fr.ideafactory.pattern.models.Bad;
import fr.ideafactory.pattern.models.Character;
import fr.ideafactory.pattern.models.Gun;
import fr.ideafactory.pattern.models.Hero;
import fr.ideafactory.pattern.models.Knife;
import fr.ideafactory.pattern.models.Weapon;
import fr.ideafactory.pattern.prototype.Fight;
import fr.ideafactory.pattern.prototype.Meet;
import fr.ideafactory.pattern.prototype.MeetRegistry;
import fr.ideafactory.pattern.prototype.Negociation;
import fr.ideafactory.pattern.adapter.MYSQLSelect;
import fr.ideafactory.pattern.adapter.PGSQLAdapter;
import fr.ideafactory.pattern.adapter.PGSQLSelect;
import fr.ideafactory.pattern.bridge.SuccessSubmitButton;
import fr.ideafactory.pattern.builder.HeroBuilder;
import fr.ideafactory.pattern.builder.HeroDirector;
import fr.ideafactory.pattern.builder.PoorHeroBuilder;
import fr.ideafactory.pattern.builder.StrongHeroBuilder;
import fr.ideafactory.pattern.composite.Component;
import fr.ideafactory.pattern.composite.Composite;
import fr.ideafactory.pattern.cor.HttpRequest;
import fr.ideafactory.pattern.cor.HttpRequestHandler;
import fr.ideafactory.pattern.cor.HttpRequestHandlerInterface;
import fr.ideafactory.pattern.cor.ProtocolHandler;
import fr.ideafactory.pattern.cor.VerbHandler;
import fr.ideafactory.pattern.decorator.Buy;
import fr.ideafactory.pattern.decorator.BuyEquipment;
import fr.ideafactory.pattern.decorator.BuyEquipmentWithExtra;
import fr.ideafactory.pattern.decorator.BuyEquipmentWithInsurance;
import fr.ideafactory.pattern.exceptions.NoHttpHandlerException;
import fr.ideafactory.pattern.exceptions.ProtectionNotFoundException;
import fr.ideafactory.pattern.exceptions.ProtocolNotHandledException;
import fr.ideafactory.pattern.exceptions.VerbNotAllowedException;
import fr.ideafactory.pattern.exceptions.WeaponNotFoundException;
import fr.ideafactory.pattern.facade.MeetFacade;
import fr.ideafactory.pattern.factory.AbstractFactory;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws WeaponNotFoundException, ProtectionNotFoundException
    {
    	// Implements Factory
        CharacterFactory heroFactory = new HeroFactory();
        CharacterFactory badFactory = new BadFactory();
        
        Character superman = heroFactory.createCharacter();
        Character joker = badFactory.createCharacter();
        
        superman.setName("Superman");
        joker.setName("Joker");
        joker.setLifePoints(1500);
        
        System.out.println(superman.whoAreYou());
        System.out.println(joker.whoAreYou());
        
        // Implements AbstractFactory
        AbstractFactory abstractFactory = FactoryProvider.getFactory("weapon");
        Gun handGun = (Gun) abstractFactory.create("gun");
        Knife myKnife = (Knife) abstractFactory.create("knife");
        
        abstractFactory = FactoryProvider.getFactory("protection");
        Armour myArmour = (Armour) abstractFactory.create("armour");
        
        System.out.println("My gun : " + handGun.getType() + "(" + handGun.getStrength() + ")");
        
        // Implements Builder pattern
        HeroDirector heroDirector = new HeroDirector();
        
        HeroBuilder strongHeroBuilder = new StrongHeroBuilder();
        heroDirector.setBuilder(strongHeroBuilder);
        heroDirector.make();
        Hero batman = strongHeroBuilder.get();
        batman.setName("Batman");
        
        HeroBuilder poorHeroBuilder = new PoorHeroBuilder();
        heroDirector.setBuilder(poorHeroBuilder);
        heroDirector.make();
        Hero tarzan = poorHeroBuilder.get();
        tarzan.setName("Tarzan");
        
        System.out.println(batman.whoAreYou() + " / " + tarzan.whoAreYou());
        
        // Prototype implementation
        MeetRegistry registry = new MeetRegistry();
        
        // Create a Negociation and a Fight
        Negociation friendlyMeeting = new Negociation();
        friendlyMeeting.setHero(batman);
        friendlyMeeting.setBad((Bad) joker);
        friendlyMeeting.setPointExchanges(100);
        registry.add(friendlyMeeting);
        
        Fight rudeFight = new Fight();
        rudeFight.setHero(tarzan);
        rudeFight.setBad((Bad) joker);
        rudeFight.setWinnerGains(200);
        registry.add(rudeFight);
        
        // Clone each other
        registry.add((Meet) rudeFight.clone());
        registry.add((Meet) friendlyMeeting.clone());
        
        // Custom clone...
        Meet aFight = registry.byId(3);
        ((Fight) aFight).setWinnerGains(500);
        
        // Then walk through Meetings...
        registry.get().forEach((key, value) -> System.out.println("Key : " + key + " => " + value));
        
        // Let's play with Facade
        System.out.println("Before (Hero) : " + aFight.getHero().getName() + " : " + aFight.getHero().getLifePoints());
        System.out.println("Before (Bad) : " + aFight.getBad().getName() + " : " + aFight.getBad().getLifePoints());
        new MeetFacade(aFight); // Business logic was hidden by the Facade pattern
        System.out.println("After (Hero) : " + aFight.getHero().getName() + " : " + aFight.getHero().getLifePoints());
        System.out.println("After (Bad) : " + aFight.getBad().getName() + " : " + aFight.getBad().getLifePoints());
        
        // Using decorators
        Buy singleEquipment = new BuyEquipment();
        System.out.println("Single equipment cost : " + singleEquipment.cost());
        
        Buy equipmentWithExtra = new BuyEquipmentWithExtra(singleEquipment);
        System.out.println("Equipment with extra full cost : " + equipmentWithExtra.cost());
        
        Buy equipmentWithInsurance = new BuyEquipmentWithInsurance(singleEquipment);
        System.out.println("Equipment with insurance full cost : " + equipmentWithInsurance.cost());
        
        // To get full options costs
        Buy equipment = new BuyEquipment();
        Buy withExtra = new BuyEquipmentWithExtra(equipment);
        Buy fullOptionsEquipment = new BuyEquipmentWithInsurance(withExtra);
        System.out.println("Full option equipement cost : " + fullOptionsEquipment.cost());
        
        // Playing with Adapter
        MYSQLSelect select = new MYSQLSelect();
        System.out.println("Like operation for MySQL : " + select.likeClause("Hero"));
        PGSQLAdapter adapter = new PGSQLAdapter();
        PGSQLSelect pgSelect = new PGSQLSelect(adapter);
        System.out.println("Like operation for PGSQL : " + pgSelect.likeClause("Hero"));
        
        // Create button with Bridge Implementation
        SuccessSubmitButton button = new SuccessSubmitButton();
        System.out.println("Button was rendered as : " + button.render());
        
        // Using Composite to compute a whole pack
        Component battery1 = new Component("battery", 1.50);
        Component battery2 = new Component("battery", 1.50);
        Composite batteryPack = new Composite();
        batteryPack.add(battery1).add(battery2);
        
        Component remote = new Component("Remote Controller", 15.00);
        
        Composite remotePack = new Composite();
        remotePack.add(remote).add(batteryPack);
        
        System.out.println("Total cost of remotePack : " + remotePack.totalize());
        
        //Playing with COR
        HttpRequest request = new HttpRequest();
        request.protocol = "https";
        request.verb = "get";
        request.route = "/user";
        
        HttpRequestHandlerInterface protocolHandler = new ProtocolHandler();
        HttpRequestHandlerInterface verbHandler = new VerbHandler();
        
        protocolHandler.next(verbHandler);
        
        // Go through the chain
        try {
        	HttpRequestHandler lastHandler = (HttpRequestHandler) protocolHandler.handle(request);
        	System.out.println(lastHandler);
        } catch (NoHttpHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolNotHandledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VerbNotAllowedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
