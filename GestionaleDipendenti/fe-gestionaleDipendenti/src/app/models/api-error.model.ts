import { ErrorDetail } from "./error-detail.model";

export interface APIError{
    timestamp: Date;
    path: string;
    details: ErrorDetail;
}