package com.example.movieposter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostersListener {

    private Button buttonAddToWatchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.postersRecycleView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchList);

        //prepare data

        List<Poster> posterList = new ArrayList<>();

        //below is different movies available for selection
        Poster the100 =new Poster();
        the100.image = R.drawable.movie1;
        the100.name = "Monster House";
        the100.createdBy = "Gil Kenan";
        the100.rating =3f;
        the100.story = "A haunted house that traps 3 teens, will they find a way out?";
        posterList.add(the100);

        Poster thor =new Poster();
        thor.image = R.drawable.movie2;
        thor.name = "Thor: Ragnark";
        thor.createdBy = "Taika Waititi";
        thor.rating =5f;
        thor.story = "Thor's quest for survival leads him in a race against time to prevent Hela from destroying his home world" +
                "and the Asgardian civilization";
        posterList.add(thor);

        Poster aladdin =new Poster();
        aladdin.image = R.drawable.movie3;
        aladdin.name = "Aladdin";
        aladdin.createdBy = "Ron Clements";
        aladdin.rating =4f;
        aladdin.story = "Aladdin meets a genie and they must soon embark on a dangerous mission to stop the evil sorcer" +
                "Jafar from overthrowing young Jasmine's kingdom";
        posterList.add(aladdin);

        Poster ironMan =new Poster();
        ironMan.image = R.drawable.movie4;
        ironMan.name = "Iron Man";
        ironMan.createdBy = "Jon Favreau";
        ironMan.rating =5f;
        ironMan.story = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates " +
                "a unique weaponized suit of armor to fight evil";
        posterList.add(ironMan);

        Poster doctorStrange =new Poster();
        doctorStrange.image = R.drawable.movie5;
        doctorStrange.name = "Doctor Strange";
        doctorStrange.createdBy = "Scott Derrickson";
        doctorStrange.rating =4f;
        doctorStrange.story = "While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn " +
                "into the world of the mystic arts";
        posterList.add(doctorStrange);

        Poster captainAmerica =new Poster();
        captainAmerica.image = R.drawable.movie6;
        captainAmerica.name = "Captain America The First avenger";
        captainAmerica.createdBy = "Joe Johnston";
        captainAmerica.rating =4f;
        captainAmerica.story = "Steve Rogers, a rejected military soldier, transforms into Captain America after taking a dose of a " +
                "Super-Soldier serum. But being Captain America comes at a price as he " +
                "attempts to take down a warmonger and a terrorist organization";
        posterList.add(captainAmerica);

        Poster civilWar =new Poster();
        civilWar.image = R.drawable.movie7;
        civilWar.name = "Captain America: Civil War";
        civilWar.createdBy = "Joe Russo";
        civilWar.rating =5f;
        civilWar.story = "Political involvement in the Avengers' affairs causes a rift between Captain America and Iron Man.";
        posterList.add(ironMan);

        Poster polarExpress =new Poster();
        polarExpress.image = R.drawable.movie8;
        polarExpress.name = "The Polar Express";
        polarExpress.createdBy = "Robert Zemeckis";
        polarExpress.rating =3f;
        polarExpress.story = "On Christmas Eve, a young boy embarks on a magical adventure to the North Pole on the Polar Express, " +
                "while learning about friendship, bravery, and the spirit of Christmas.";
        posterList.add(polarExpress);

        Poster conjuring =new Poster();
        conjuring.image = R.drawable.movie9;
        conjuring.name = "The Conjuring";
        conjuring.createdBy = "James Wan";
        conjuring.rating =4f;
        conjuring.story = "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by " +
                "a dark presence in their farmhouse.";
        posterList.add(conjuring);

        Poster eightMile =new Poster();
        eightMile.image = R.drawable.movie10;
        eightMile.name = "8 Mile";
        eightMile.createdBy = "Curtis Hanson";
        eightMile.rating =3f;
        eightMile.story = "Follows a young rapper in the Detroit area, struggling with every aspect of his life; he wants to " +
                "make it big but his friends and foes make this odyssey " +
                "of rap harder than it may seem";
        posterList.add(eightMile);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();
                for(int i = 0; i < selectPosters.size(); i++) {
                    if(i == 0){
                        posterNames.append(selectPosters.get(i).name);
                    } else{
                        posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected) {
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        } else {
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}