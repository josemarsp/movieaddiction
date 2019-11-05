package br.com.josef.movieaddiction.model.data;

import java.util.Date;
import androidx.room.TypeConverter;

public class Converter {



        @TypeConverter
        public Date toDate(Long timestamp) {
            if (timestamp == null) {
                return null;
            } else {
                return new Date(timestamp);
            }
        }

        @TypeConverter
        public Long toTimestamp(Date date) {
            return date.getTime();
        }


}
