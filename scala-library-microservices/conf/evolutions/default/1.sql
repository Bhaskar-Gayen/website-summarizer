create table if not exists logs."WebsiteSummarizeLog" (
    "timestamp" TIMESTAMP WITH TIME ZONE NOT NULL,
    "website" VARCHAR NOT NULL);