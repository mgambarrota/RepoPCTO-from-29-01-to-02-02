import { ErrorDetail } from "./error-detail.model";

export interface ApiError {
  timestamp: Date;
  path: string;
  details: ErrorDetail;
}
