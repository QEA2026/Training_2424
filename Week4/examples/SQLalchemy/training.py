from os import getenv

from dotenv import load_dotenv
import pandas as pd
from sqlalchemy import create_engine


load_dotenv()
CS = getenv("CS")
engine = create_engine(CS)

query = "SELECT * FROM employees;"
df = pd.read_sql(query, engine)
print(df)

df.to_sql(
    name = "processed",
    con=engine,
    if_exists = 'replace',
    index=False
)
