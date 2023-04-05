package spring.dltespringjdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class DepositService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<FixedDeposits> show(){
        return jdbcTemplate.query("select * from fixed_deposits", new DepositMapper());
    }

    private class DepositMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            FixedDeposits fixedDeposits=new FixedDeposits();
            fixedDeposits.setDeposite_id(rs.getInt("deposit_id"));
            fixedDeposits.setDeposite_amt(rs.getDouble("deposit_amt"));
            fixedDeposits.setDeposite_tenure(rs.getInt("deposit_tenure"));
            fixedDeposits.setDeposite_date(rs.getDate("deposit_date"));
            fixedDeposits.setInterest_rate(rs.getFloat("interest_rate"));
            fixedDeposits.setMature_date(rs.getDate("mature_date"));
            fixedDeposits.setMature_amt(rs.getDouble("mature_amt"));
            fixedDeposits.setMode_of_div(rs.getString("mode_of_dividend"));
            return null;
        }
        }
    }
