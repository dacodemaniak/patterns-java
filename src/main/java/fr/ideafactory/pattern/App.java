package fr.ideafactory.pattern;

import fr.ideafactory.pattern.factory.BadFactory;
import fr.ideafactory.pattern.factory.CharacterFactory;
import fr.ideafactory.pattern.factory.FactoryProvider;
import fr.ideafactory.pattern.factory.HeroFactory;
import fr.ideafactory.pattern.models.Armour;
import fr.ideafactory.pattern.models.Character;
import fr.ideafactory.pattern.models.Gun;
import fr.ideafactory.pattern.models.Hero;
import fr.ideafactory.pattern.models.Knife;
import fr.ideafactory.pattern.models.Weapon;
import fr.ideafactory.pattern.builder.HeroBuilder;
import fr.ideafactory.pattern.builder.HeroDirector;
import fr.ideafactory.pattern.builder.PoorHeroBuilder;
import fr.ideafactory.pattern.builder.StrongHeroBuilder;
import fr.ideafactory.pattern.exceptions.ProtectionNotFoundException;
import fr.ideafactory.pattern.exceptions.WeaponNotFoundException;
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
        
    }
}
