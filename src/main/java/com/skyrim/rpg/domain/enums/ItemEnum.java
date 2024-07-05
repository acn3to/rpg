package com.skyrim.rpg.domain.enums;

import com.skyrim.rpg.domain.entities.Item;

public enum ItemEnum {
    SWORD_OF_TALOS(
            new Item(
                    "Sword of Talos",
                    "A legendary sword said to have been wielded by Talos himself, granting its bearer great strength and courage.",
                    150,
                    "Critical Hit Chance",
                    "Increases critical hit chance by 1",
                    1
            )
    ),
    STAFF_OF_MAGNUS(
            new Item(
                    "Staff of Magnus",
                    "An ancient staff imbued with the power to absorb and control magical energies.",
                    200,
                    "Mana Regeneration",
                    "Increase mana regeneration by 10 points",
                    10
            )
    ),
    WARHAMMER_OF_YSMIR(
            new Item(
                    "Warhammer of Ysmir",
                    "A massive warhammer believed to have been used by Ysmir Wulfharth in battles against dragons and giants.",
                    180,
                    "Rage Points",
                    "Increase rage by 10 points",
                    10
            )
    ),
    SHIELD_OF_SHOR(
            new Item(
                    "Shield of Shor",
                    "A sturdy shield that invokes the protection of Shor, granting its bearer enhanced defense against all foes.",
                    120,
                    "Defense Points",
                    "Increases defense by 5 points",
                    5
            )
    ),
    AMULET_OF_KYNARETH(
            new Item(
                    "Amulet of Kynareth",
                    "An enchanted amulet that channels the blessings of Kynareth, enhancing intelligence and spellcasting abilities.",
                    220,
                    "Intelligence Points",
                    "Increases intelligence by 5 points",
                    5
            )
    ),
    ELIXIR_OF_KYNE(
            new Item(
                    "Elixir of Kyne",
                    "A sacred elixir brewed from the herbs blessed by Kyne herself, granting its drinker unmatched stamina and endurance.",
                    160,
                    "Stamina Points",
                    "Increases stamina by 10 points",
                    10
            )
    ),
    DAGGER_OF_SITHIS(
            new Item(
                    "Dagger of Sithis",
                    "A dark dagger believed to be connected to the mysterious cult of Sithis, coated with a deadly poison.",
                    170,
                    "Poison Damage",
                    "Increase poison damage by 9 points",
                    9
            )
    ),
    POTION_OF_THE_DIVINES(
            new Item(
                    "Potion of the Divines",
                    "A divine potion crafted by the gods themselves, enhancing the physical strength of its drinker.",
                    190,
                    "Strength Points",
                    "Increases strength by 5 points",
                    5
            )
    );

    private final Item item;

    ItemEnum(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "ItemEnum{" +
                "item=" + getItem() +
                '}';
    }
}
