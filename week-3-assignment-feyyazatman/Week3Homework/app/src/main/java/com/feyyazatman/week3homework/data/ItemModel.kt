package com.feyyazatman.week3homework.data

import android.os.Parcelable
import com.feyyazatman.week3homework.R
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemModel(
    val id : String,
    val ItemName : String,
    val ItemPrice : String,
    val ItemImage : Int,
    val ItemDescription :String
) : Parcelable {
    fun toJson() : String {
        return Gson().toJson(this)
    }
    companion object {
        fun fromJson(jsonValue: String) : ItemModel {
            return Gson().fromJson(jsonValue, ItemModel::class.java)
        }
    }
}

val skinListData = mutableListOf(
    ItemModel(
        "1",
        "TRICK OR TREAT",
        "310",
        R.drawable.trick_or_treat,
        "The night has come! Put on the best style and live a terrifying and fun night with your friends.\n" +
                "\n" +
                "+ 10 different Skins."

    ),
    ItemModel(
        "2",
        "DRAGON RIDERS",
        "490",
        R.drawable.dragon,
        "Do you like dragons and have you ever wanted to ride on one? Then this is the perfect pack for you!\n" +
                "Grab your suit and go on an unforgettable ride.\n" +
                "\n" +
                "+ 8 Dragon Themed Skins\n" +
                "+ HD Features"

    ),
    ItemModel(
        "3",
        "FIRE DEMONS VS ICE TEENS",
        "310",
        R.drawable.fire_demons_ice_teens,
        "Pick your side by joining the squad of firey demons or the team of courageous teenagers. Impress everyone with your new outfits!\n" +
                "\n" +
                "+ 12 fire- and ice-themed skins\n" +
                "+ Great for roleplay\n" +
                "+ Published by BLOCKLAB Studios under license from Miracles Studios."

    ),
    ItemModel(
        "4",
        "HALLOWEEN FRIENDS",
        "310",
        R.drawable.halloween_friends,
        "Halloween is here! Ghosts, zombies and skeletons have arrived in this haunted city!\n" +
                "\n" +
                "+ 1 free skin\n" +
                "+ 12 skins\n" +
                "+ By: MobBlocks."

    ),
    ItemModel(
        "5",
        "APHMAU AND FRIENDS",
        "310",
        R.drawable.aphway_and_friends,
        "Hey guys! Aphmau here and this is my FIRST SKIN PACK! (^.^) I’m SUPER excited to share with you guys our Minecraft Skins! Now you can play as your favorite characters featured on my Aphmau YouTube Channel!\n" +
                "\n" +
                "Skins Featured [10 in total]:\n" +
                "+ 2 Aphmau Skins\n" +
                "+ 2 Aaron Skins"
    ),
    ItemModel(
        "6",
        "THE BACKROOMS",
        "310",
        R.drawable.the_backrooms,
        "Are you brave enough to venture into the backrooms. Each doorway houses a new horror. Enter if you dare.\n" +
                "\n" +
                "+ 12 Unique Skins\n" +
                "+ Roleplaying, Survival & Horror\n" +
                "+ FREE Skin: Jane Doe"

    ),
    ItemModel(
        "7",
        "SUMMER GIFT",
        "490",
        R.drawable.summer_gift,
        "A summer gift from Cypress Games for the Minecraft players!\n" +
                "\n" +
                "+ 8 Summer themed free skins"

    ),
    ItemModel(
        "8",
        "ANIME TRENDS",
        "490",
        R.drawable.anime_trend,
        "Catch the popular anime trends and keep up with them with this pack! Choose your favorite skin from this pack designed with the sweetness of anime and amaze other players!\n" +
                "\n" +
                "+ 14 skins including 2 that are FREE!\n" +
                "+ Perfect for roleplay."
    ),


)
val textureListData = mutableListOf(
    ItemModel(
        "1",
        "SUPER CUTE",
        "1170",
        R.drawable.super_cute,
        "Make your Minecraft worlds Super Cute! With adorable creatures, playful UI, a bubbly theme, and so much more, you won't be able to go back. Choose between 15 skins to match your tiny friends!"
    ),
    ItemModel(
        "2",
        "STORYTIME",
        "990",
        R.drawable.story_time,
        "Start your adventure with this cute crafted texture pack. It's time to create your own story!\n" +
                "\n" +
                "+ Bright, colourful with a fairy tale vibe\n" +
                "+ Fully custom textures for blocks, tools, mobs, and more!\n" +
                "+ Custom UI\n" +
                "+ Supports 1.19 update!"
    ),
    ItemModel(
        "3",
        "REBLOCKS",
        "990",
        R.drawable.reblocks,
        "ReBlocks texture pack is a medieval-looking texture pack with multiple resolutions to choose from that mixes stylized with a semi-realistic look.\n" +
                "Extensive texture variations will make your worlds even more realistic.\n" +
                "\n" +
                "Multi resolutions:\n" +
                "- 16px\n" +
                "- 32px HD\n" +
                "- 64px HD\n" +
                "- 128px HD"
    ),
    ItemModel(
        "4",
        "SOLR",
        "660",
        R.drawable.solr,
        "Is SOLR the PvP pack you've been looking for? This dark red themed pack will heighten your fighting senses!\n" +
                "\n" +
                "+ Low fire\n" +
                "+ Short swords and tools\n" +
                "+ Outlined ores\n" +
                "+ Custom particles\n" +
                "+ Mobile friendly\n" +
                "+ Dark themed GUIs\n" +
                "+ Supports 1.19 content"
    ),
    ItemModel(
        "5",
        "CONQUEST",
        "990",
        R.drawable.conquest,
        "Conquer new worlds with these hand-crafted, realistic textures! Perfect for building gritty Medieval castles, desert bazaars, towering pagodas, or even industrial factories in amazing detail.\n" +
                "\n" +
                "-32x32 HD textures\n" +
                "-Extensive texture variations to make your worlds even more realistic\n" +
                "-Unique textures for many blocks like fences, slabs, even double slabs!\n" +
                "-Full Custom UI"
    ),
    ItemModel(
        "6",
        "ANTIQUE",
        "1340",
        R.drawable.antique,
        "Traverse into a new vintage look with Antique Texture Pack! These old-school textures not only bring freedom and prosperity to worlds but also a never before seen classic look. Free skin included!\n" +
                "\n" +
                "+ Old Times\n" +
                "+ Vintage Look\n" +
                "+ Custom UI & Font\n" +
                "+ Free Skin"
    ),
    ItemModel(
        "7",
        "RUSTIC",
        "830",
        R.drawable.rustic,
        "Transform your world with these rustic-inspired textures! Perfect for roleplaying in a fantasy or medieval world, or for builders looking to add an old-school aesthetic to their structures. With support for the latest version of Minecraft, you'll always have the latest and greatest looks!\n" +
                "\n" +
                "+ Kept up-to-date for 1.18\n" +
                "+ Detailed textures with an old-school vibe"
    ),
    ItemModel(
        "8",
        "BONBON",
        "830",
        R.drawable.bonbon,
        "It's bonbon time! Turn your world into an exciting happy & delicious place. Warning, this pack might be too cute and may cause you to say 'aww that's cute' a lot!\n" +
                "- Bonbon themed texture pack\n" +
                "- 36 amazing skins\n" +
                "- 1 free skin\n" +
                "- by Lostduckies & Pixelusion"
    )
)
val mapsListData = mutableListOf(
    ItemModel(
        "1",
        "SANDSTONE",
        "660",
        R.drawable.sandstone,
        "My original Sandstone \"Complete the Monument\" map, fully updated and enhanced for Bedrock.\n" +
                "\n" +
                "Complete 3 dungeons while exploring a beautiful sandstone world. Collect and craft the 4 monument blocks, returning them to the Sandstone Temple.\n" +
                "\n" +
                "+ Fun mob variants\n" +
                "+ Custom Potions and Foods\n" +
                "+ Unique Weapons with mysterious lore\n" +
                "+ A single duck (many)\n" +
                "+ TIP signs"
    ),
    ItemModel(
        "2",
        "GRAVE DANGER",
        "990",
        R.drawable.grave_danger,
        "The castle is under attack by hordes of undead monsters! Protect and free the castle from the invaders with the help of traps, magical weapons, and your trusty companion! Fight zombies, undead plushies, and many more fantastic creatures. Unlock more weapons and traps to help you defend the castle!\n" +
                "\n" +
                "+ 20+ traps\n" +
                "+ 7 magical weapons\n" +
                "+ Boss fights\n" +
                "+ Custom music"
    ),
    ItemModel(
        "3",
        "SEASIDE STORY",
        "990",
        R.drawable.seaside_story,
        "Live out your own peaceful ocean adventure! Go fishing and discover amazing creatures in brand new ocean biomes. Customize your boat, upgrade the island, and fill the aquarium with the fish you catch. Full of secrets to discover, friends to make, and ecosystems to clean, it's time to start your seaside story!"
    ),
    ItemModel(
        "4",
        "BEACH ISLAND",
        "490",
        R.drawable.beach_island,
        "This summer may be over but it's still going on here on the beach island! Explore this big island and see the hidden beauty inside with your friends. Let's start the tour!\n" +
                "\n" +
                "- Has a big mysterious volcano in the center!\n" +
                "- Some rest areas and a surprise house!\n" +
                "- By Rainbow Theory Studios"
    ),
    ItemModel(
        "5",
        "NATURE LIFE",
        "660",
        R.drawable.nature_life,
        "Check out this new fun map! You have never been so in nature. \"Nature Life\" with its beautiful environment and atmosphere!\n" +
                "\n" +
                "- 5+ Additional Mobs!\n" +
                "- Special Recipes!\n" +
                "- Perfect Survival Experince!\n" +
                "- By Team A.k.A. under Piki Studios"
    ),
    ItemModel(
        "6",
        "CRUISE CHAOS",
        "830",
        R.drawable.cruise_chaos,
        "Be the hero of this quaint English seaside town - stop the cruise ship from sinking! Race to the cruise ship using the coast guard boat and extinguish the fires! Roleplay in the village, or make the cruise ship your own base!\n" +
                "\n" +
                "+ Cruise ship with full interior\n" +
                "+ 4 unique coastguard vehicles\n" +
                "+ Numerous furniture pieces\n" +
                "\n" +
                "Produced in collaboration with Nether Pixel Studios."
    ),
    ItemModel(
        "7",
        "CREEPER PALACE",
        "310",
        R.drawable.creeper_palace,
        "How about starting a new adventure? On this map you can go through challenges you've never been through before!\n" +
                "\n" +
                "- Parkour, mazes, hidden secrets and much more!\n" +
                "- 4 skins\n" +
                "- Multiplayer Game\n" +
                "- Easy/Medium and Hard/Impossible Stages!\n" +
                "\n" +
                "- By Pixell Studio & Stallyun Creations"
    ),
    ItemModel(
        "8",
        "ZOMBIE DINOSAURS",
        "660",
        R.drawable.zombie_dinosaurs,
        "The once beautiful dinosaur zoo has been overrun by zombies! Train your velociraptor to collect loot and craft cars and better weapons. How long will you survive in this apocalyptic world?"
    )
)