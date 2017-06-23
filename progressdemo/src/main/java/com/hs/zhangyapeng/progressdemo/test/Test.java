/**
 * 	FireZenk's Progress Bar <A highly customizable progress bar>
 *  Copyright (C) 2012 Jorge Garrido Oval (aka: FireZenk)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hs.zhangyapeng.progressdemo.test;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hs.zhangyapeng.progressdemo.FZProgressBar;
import com.hs.zhangyapeng.progressdemo.FZProgressBar.Mode;
import com.hs.zhangyapeng.progressdemo.R;

public class Test extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Retrieve the first progress bar

        //Configure the first progress bar

        //Retrieve the second progress bar
        final FZProgressBar mBar2 = (FZProgressBar) findViewById(R.id.fancyBar2);
        
        //Configure the second progress bar
        mBar2.animation_config(2, 5);
        int[] colors2 = {Color.GREEN,Color.WHITE,Color.YELLOW, Color.BLUE};
        mBar2.bar_config(50, 0, 10, Color.BLACK, colors2);
        

        //Retrieve the third progress bar

        Button b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Start the animation of the progress bars assigning them their mode
                int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
				mBar2.animation_start(Mode.ONESHOT,0.8*screenWidth);

			}
		});
        
        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Stop the animation of progress bars
				mBar2.animation_stop();
			}
		});
        

    }
    
}